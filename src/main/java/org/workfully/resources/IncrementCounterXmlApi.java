package org.workfully.resources;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.workfully.controllers.OperationTrackerDBController;


@Path("incrementcounter") // https:localhost:8081/xml-api/increment/       
public class IncrementCounterXmlApi {

    OperationTrackerDBController operationTrackerDBController;


    @PUT
    @Path("/getproducts")
    @Produces(MediaType.APPLICATION_XML)
    public String incrementGetProducts(){
        String statusCode = "";
        

        //TODO IMPLEMENT INCREMENTATION ON THE TAG <getProducts>

        return statusCode;
    }

    @PUT
    @Path("/getproduct")
    @Produces(MediaType.APPLICATION_XML)
    public String incrementGetProduct() {


        //TODO IMPLEMENT INCREMENTATION ON TAG <getProduct>


        return "Got it!";
    }
}
