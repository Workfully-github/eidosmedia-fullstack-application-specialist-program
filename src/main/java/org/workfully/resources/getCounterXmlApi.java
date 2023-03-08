package org.workfully.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("getcounter")
public class getCounterXmlApi {

    @GET
    @Path(("/getproducts"))
    @Produces(MediaType.APPLICATION_XML)
    public String getProductsCounter() {
        // TODO IMPLEMENT GET COUNTERS

        return "Got it";
    }
    
}
