package org.workfully.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.workfully.http.RestController;

@Path("categories")
public class Categories {

    private RestController rest = new RestController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String categories() throws JSONException {

        try {
            rest.updateStats("categories");
            return rest.getBody("https://dummyjson.com/products/categories");
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: " + e.getMessage();
        }
    }
}
