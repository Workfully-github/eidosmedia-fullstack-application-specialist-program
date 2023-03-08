package org.workfully.resources;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.w3c.dom.NodeList;
import org.workfully.controllers.OperationTrackerDBController;


@Path("increment") // https:localhost:8081/xml-api/increment/       
public class IncrementCounterXmlApi {

    OperationTrackerDBController operationTrackerDBController;


    @PUT
    @Path("/getproducts")
    @Produces(MediaType.APPLICATION_XML)
    public String incrementGetProducts(){
        String statusCode = "";
        
        NodeList elemment = operationTrackerDBController.getXmlDB().getElementsByTagName("productsCounter");
        System.out.println(elemment);

        return statusCode;
    }

    @PUT
    @Path("/getproduct")
    @Produces(MediaType.TEXT_PLAIN)
    public String incrementGetProduct() {
        return "Got it!";
    }
}
