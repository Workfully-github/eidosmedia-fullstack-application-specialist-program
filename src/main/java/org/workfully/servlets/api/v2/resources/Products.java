package org.workfully.servlets.api.v2.resources;

import java.io.File;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.workfully.utils.MakeFileUtils;
import org.workfully.utils.RestUtils;

@Path("products")
public class Products {

    private RestUtils rest = new RestUtils();
    private final static String RESOURCES_BASE_PATH = "src/main/java/org/workfully/resources/";
    private final static String HEROKU_RESOURCES_BASE_PATH = System.getenv("RESOURCES_BASE_PATH");
    
    private static String getAllProductsResponse = null;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts(@QueryParam("limit") int limit, @QueryParam("skip") int skip) {
        final String GET_PRODUCTS_PATH = "get_products_" + "l" + limit + "&" + "s" + skip;
        try {
            String request = "https://dummyjson.com/products?limit=" + (limit == 0 ? 30 : limit) + "&skip=" + skip;
            String response = rest.getBody(request).getEntity().toString();
            File file = MakeFileUtils.makeFile(response, GET_PRODUCTS_PATH);
            String localResponse = MakeFileUtils.readFile(file);

            rest.updateStats("page");
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
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("id") int id) {
        final String PRODUCT_ID_PATH = "product_id_" + id;

        try {
            String request = "https://dummyjson.com/products/" + id;
            String response = rest.getBody(request).getEntity().toString();
            File file = MakeFileUtils.makeFile(response, PRODUCT_ID_PATH);
            String localResponse = MakeFileUtils.readFile(file);

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
            String request = "https://dummyjson.com/products/search?q=" + query;
            String response = rest.getBody(request).getEntity().toString();
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
            String request = "https://dummyjson.com/products/category/" + category;
            String response = rest.getBody(request).getEntity().toString();

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
        final String ALL_PRODUCTS = "allproducts";
        String request = "https://dummyjson.com/products?limit=100";
        try {
            callApiIfResponseNull(Products.getAllProductsResponse, request);
            File file = MakeFileUtils.makeFile(getAllProductsResponse, ALL_PRODUCTS);
            String localResponse = MakeFileUtils.readFile(file);
            rest.updateStats("products");
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

    public static void main(String[] args) {
        Products products = new Products();
        products.getAllProducts();
    }

    public void callApiIfResponseNull(String response, String request) {
        if (response == null) {
            getAllProductsResponse = rest.getBody(request).getEntity().toString();
        }
    }

    public void cronJobIfApiResponseDifferent(String response, String request) {
        if (response.hashCode() != rest.getBody(request).getEntity().toString().hashCode()) {
            getAllProductsResponse = rest.getBody(request).getEntity().toString();
            System.out.println("Api called, Hash Code is different...");
        }
    }

    public void cronJob() {
        final String REQUEST_ALL_PRODUCTS = "https://dummyjson.com/products?limit=100";
        cronJobIfApiResponseDifferent(Products.getAllProductsResponse, REQUEST_ALL_PRODUCTS);
    }
}
