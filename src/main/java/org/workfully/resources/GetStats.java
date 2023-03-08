package org.workfully.resources;

import java.io.StringWriter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.workfully.controllers.OperationTrackerDBController;

@Path("stats")
public class GetStats {
    OperationTrackerDBController operationTrackerDBController;

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getProductsCounter() {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            Document stats = operationTrackerDBController.getXmlDB();
            transformer = tf.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(stats), new StreamResult(writer));
            String xmlString = writer.getBuffer().toString();
            return xmlString;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
