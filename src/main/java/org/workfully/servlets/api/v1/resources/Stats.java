package org.workfully.servlets.api.v1.resources;

import java.io.StringReader;
import java.io.StringWriter;
import java.rmi.server.Operation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.workfully.controllers.OperationTrackerController;
import org.workfully.model.OperationTracker;
import org.workfully.utils.RestUtils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

@Path("stats")
public class Stats {

    private OperationTrackerController opt = new OperationTrackerController();
    private RestUtils rest = new RestUtils();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStats() {
        try {
            String request = rest.getBody("https://optracker.herokuapp.com/api/stats/");
            return Response.ok()
                    .entity(opt.convertToJson(request))
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET")
                    .allow("GET").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}