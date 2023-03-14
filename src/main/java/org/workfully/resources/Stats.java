package org.workfully.resources;

import java.io.StringReader;
import java.io.StringWriter;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.workfully.http.RestController;
import org.workfully.model.OperationTracker;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

/* import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller; */


@Path("stats")
public class Stats {

    private RestController rest = new RestController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getStats() {
        try {
            String xml = rest.getBody("https://optracker.herokuapp.com/api/stats/");
            OperationTracker ot = unmarshalXml(xml);
            return convertToJson(ot);
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: " + e.getMessage();
        }
    }
    
    private OperationTracker unmarshalXml(String xml) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(OperationTracker.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        return (OperationTracker) unmarshaller.unmarshal(new StringReader(xml));
    }
    
    private String convertToJson(OperationTracker ot) throws JSONException, JAXBException {
        JAXBContext jc = JAXBContext.newInstance(OperationTracker.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    
        StringWriter sw = new StringWriter();
        marshaller.marshal(ot, sw);
        String formattedXml = sw.toString();
    
        JSONObject jsonObject = XML.toJSONObject(formattedXml);
        return jsonObject.toString();
    }
    
}