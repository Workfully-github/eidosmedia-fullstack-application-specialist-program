package org.workfully.servlets.api.v1.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.workfully.utils.RestUtils;

@Path("categories")
public class Categories {

    private RestUtils rest = new RestUtils();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response categories() throws JSONException {
        try {
            String request = rest.getBody("https://dummyjson.com/products/categories").getEntity().toString();
            rest.updateStats("categories");
            return Response.ok()
                    .entity(request)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET")
                    .encoding("gzip")
                    .allow("GET").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
