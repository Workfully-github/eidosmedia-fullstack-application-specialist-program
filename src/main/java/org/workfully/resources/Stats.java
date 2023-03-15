package org.workfully.resources;

import java.io.StringReader;
import java.io.StringWriter;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.workfully.model.OperationTracker;
import org.workfully.utils.RestUtils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

@Path("stats")
public class Stats {

    private RestUtils rest = new RestUtils();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStats() {
        try {
            String request = rest.getBody("https://optracker.herokuapp.com/api/stats/");
            return Response.ok()
                    .entity(convertToJson(request))
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET")
                    .allow("GET").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    private OperationTracker unmarshalledXml(String xml) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(OperationTracker.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        return (OperationTracker) unmarshaller.unmarshal(new StringReader(xml));
    }

    private String marshalledXml(OperationTracker unmarshalledOperationTracker) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(OperationTracker.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter sw = new StringWriter();
        marshaller.marshal(unmarshalledOperationTracker, sw);
        String formattedXml = sw.toString();

        JSONObject jsonObject = XML.toJSONObject(formattedXml);
        return jsonObject.toString();
    }

    private String convertToJson(String xmlRequest) throws JSONException, JAXBException {
        OperationTracker ot = unmarshalledXml(xmlRequest);
        return marshalledXml(ot);
    }

}