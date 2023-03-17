package org.workfully.servlets.api.v1.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.workfully.utils.RestUtils;

@Path("products")
public class Products {

    private RestUtils rest = new RestUtils();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts(@QueryParam("limit") int limit, @QueryParam("skip") int skip) throws JSONException {
        try {
            String request = "https://dummyjson.com/products?limit=" + (limit == 0 ? 30 : limit) + "&skip=" + skip;
            String response = rest.getBody(request).getEntity().toString();
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
    public Response getProduct(@PathParam("id") int id) throws JSONException {
        try {
            rest.updateStats("productDetail");
            String request = "https://dummyjson.com/products/" + id;
            String response = rest.getBody(request).getEntity().toString();
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
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(@QueryParam("q") String query) throws JSONException {
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
    public Response searchByCategory(@PathParam("category") String category) throws JSONException {
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
        try {
            String request = "https://dummyjson.com/products?limit=100";
            String response = rest.getBody(request).getEntity().toString();

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
}
