package org.workfully.http;

import java.io.StringWriter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.workfully.controllers.OperationTrackerDBController;

@Path("stats")
public class GetStats {

    Logger log = LogManager.getLogger(GetStats.class.getName());

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getProductsCounter() {
        try {
            log.info("Request */xml-api/stats successeful");
            return getXMLHasString();
        } catch (Exception e) {
            log.error("Unable to perform [*/xml-api/stats] request: ", e.getMessage());
            return e.getMessage();
        }
    }

    private String getXMLHasString() throws TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        Document xmlDocument = OperationTrackerDBController.getXmlDB();
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(xmlDocument), new StreamResult(writer));
        return writer.getBuffer().toString();
    }
}
