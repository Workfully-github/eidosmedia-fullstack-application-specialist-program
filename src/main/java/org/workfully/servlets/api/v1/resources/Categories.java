package org.workfully.servlets.api.v1.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.workfully.utils.RestUtils;

@Path("categories")
public class Categories {

    private RestUtils rest = new RestUtils();

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
