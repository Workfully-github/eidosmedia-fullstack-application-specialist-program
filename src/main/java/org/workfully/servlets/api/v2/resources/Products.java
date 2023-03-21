package org.workfully.servlets.api.v2.resources;

import java.io.File;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.workfully.utils.MakeFileUtils.*;
import org.workfully.utils.RestUtils;

@Path("products")
public class Products {

    private static String allProductsLocalCache = null;
    private static String getProductsCache = null;
    private RestUtils rest = new RestUtils();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts(@QueryParam("limit") int limit, @QueryParam("skip") int skip) {
        final String FILE_NAME = "get_products_" + "limit=" + limit + "&" + "skip=" + skip;
        final String REQUEST_PATH = "https://dummyjson.com/products?limit=" + (limit == 0 ? 30 : limit) + "&" + "skip=" + skip;
        try {
            getProductsCache = callApiIfCacheNull(getProductsCache, REQUEST_PATH);
            File file = makeFile(getProductsCache, FILE_NAME);
            String response = readFile(file);
            rest.updateStats("page");
            return Response.ok()
                    .entity(response)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET")
                    .encoding("gzip")
                    .allow("GET")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("id") int id) {
        final String PRODUCT_ID_PATH = "product_id_" + id;

        try {
            String REQUEST_PATH = "https://dummyjson.com/products/" + id;
            String response = rest.getBody(REQUEST_PATH).getEntity().toString();
            File file = makeFile(response, PRODUCT_ID_PATH);
            String localResponse = readFile(file);

            rest.updateStats("productDetail");
            return Response.ok()
                    .entity(localResponse)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET")
                    .encoding("gzip")
                    .allow("GET")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(@QueryParam("q") String query) {
        // TODO Implement local caching
        try {
            String REQUEST_PATH = "https://dummyjson.com/products/search?q=" + query;
            String response = rest.getBody(REQUEST_PATH).getEntity().toString();
            rest.updateStats("search");
            return Response.ok()
                    .entity(response)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET")
                    .encoding("gzip")
                    .allow("GET")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/category/" + "{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchByCategory(@PathParam("category") String category) {
        // TODO Implement local caching
        try {
            String REQUEST_PATH = "https://dummyjson.com/products/category/" + category;
            String response = rest.getBody(REQUEST_PATH).getEntity().toString();

            rest.updateStats("category");
            return Response.ok()
                    .entity(response)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET")
                    .encoding("gzip")
                    .allow("GET")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/allproducts")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {
        final String FILE_NAME = "allproducts";
        final String REQUEST_PATH = "https://dummyjson.com/products?limit=100";
        try {
            allProductsLocalCache = callApiIfCacheNull(allProductsLocalCache, REQUEST_PATH);
            File file = makeFile(allProductsLocalCache, FILE_NAME);
            String response = readFile(file);
            rest.updateStats("products");
            return Response.ok()
                    .entity(response)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET")
                    .encoding("gzip")
                    .allow("GET")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    private String callApiIfCacheNull(String response, final String REQUEST_PATH) {
        return response == null ? rest.getBody(REQUEST_PATH).getEntity().toString() : allProductsLocalCache;
    }

    public void cronJobIfApiResponseDifferent(String response, String REQUEST_PATH) {
        if (response.hashCode() != rest.getBody(REQUEST_PATH).getEntity().toString().hashCode()) {
            allProductsLocalCache = rest.getBody(REQUEST_PATH).getEntity().toString();
            System.out.println("Api called, Hash Code is different...");
        }
    }

    public void cronJob() {
        final String REQUEST_PATH_ALL_PRODUCTS = "https://dummyjson.com/products?limit=100";
        cronJobIfApiResponseDifferent(Products.allProductsLocalCache, REQUEST_PATH_ALL_PRODUCTS);
    }
}
