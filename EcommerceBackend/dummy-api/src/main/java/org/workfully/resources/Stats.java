package org.workfully.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.workfully.controllers.StatsController;
import org.workfully.xmlresources.XmlHandler;

@Path("stats")
public class Stats {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String searchByCategory() throws JSONException {
        StatsController statsController = new StatsController();
        try {
            Document statsXmlString = new XmlHandler().getXML();
            JSONObject statsJsonObject = statsController.parseXmlToJson(statsXmlString);
            return statsJsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: " + e.getMessage();
        }
    }
}
