package com.workfully.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;

import com.workfully.http.RestController;

@Path("categories")
public class Categories {

    private RestController rest = new RestController();

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public String categories() throws JSONException {
        return rest.getBody("https://dummyjson.com/products/categories");
    }
}
