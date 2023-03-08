package com.workfully.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;

import com.workfully.http.RestController;

@Path("products")
public class Products {

    private RestController rest = new RestController();

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProducts(@QueryParam("limit") String limit, @QueryParam("skip") String skip) throws JSONException {
        if (limit != null || skip != null) {
            return rest.getBody("https://dummyjson.com/products?limit=" + limit + "&skip=" + skip);
        }

        // rest.putRequest("https://dummyjson.com/products?limit="");

        // rest.getProducts("new API", ) <---- response XML

        return rest.getBody("https://dummyjson.com/products");
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProduct(@PathParam("id") String id) throws JSONException {
        System.out.println("This is the Parameter: " + id);
        return rest.getBody("https://dummyjson.com/products/" + id);
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public String search(@QueryParam("q") String query) throws JSONException {

        System.out.println("Search Q: " + query);
        return rest.getBody("https://dummyjson.com/products/search?q=" + query);
    }

    @GET
    @Path("/category/" + "{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public String searchByCategory(@PathParam("category") String category) throws JSONException {
        return rest.getBody("https://dummyjson.com/products/category/" + category);
    }

    @GET
    @Path("/allproducts")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllProducts() {
        return rest.getBody("https://dummyjson.com/products?limit=100");
    }
}
