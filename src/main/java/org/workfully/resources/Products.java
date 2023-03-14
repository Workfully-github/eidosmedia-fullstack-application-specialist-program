package org.workfully.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.workfully.http.RestController;

@Path("products")
public class Products {

    private RestController rest = new RestController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getProducts(@QueryParam("limit") int limit, @QueryParam("skip") int skip) throws JSONException {
        try {
            if (limit == 0) {
                rest.updateStats("page");
                return rest.getBody("https://dummyjson.com/products?limit=" + 30 + "&skip=" + skip);
            }
            rest.updateStats("page");
            return rest.getBody("https://dummyjson.com/products?limit=" + limit + "&skip=" + skip);
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: " + e.getMessage();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProduct(@PathParam("id") int id) throws JSONException {
        try {
            rest.updateStats("productDetail");
            return rest.getBody("https://dummyjson.com/products/" + id);
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: " + e.getMessage();
        }
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public String search(@QueryParam("q") String query) throws JSONException {
        try {
            rest.updateStats("search");
            return rest.getBody("https://dummyjson.com/products/search?q=" + query);

        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: " + e.getMessage();
        }
    }

    @GET
    @Path("/category/" + "{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public String searchByCategory(@PathParam("category") String category) throws JSONException {
        try {
            rest.updateStats("category");
            return rest.getBody("https://dummyjson.com/products/category/" + category);

        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: " + e.getMessage();
        }
    }

    @GET
    @Path("/allproducts")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllProducts() {
        try {
            rest.updateStats("products");
            return rest.getBody("https://dummyjson.com/products?limit=100");

        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: " + e.getMessage();
        }
    }
}
