package org.workfully.http;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.workfully.model.OperationTracker;

@Path("stats")
public class GetStats {

    private Logger log = LogManager.getLogger(GetStats.class.getName());

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public OperationTracker getProductsCounter() {
        try {
            log.info("./xml-api/api/stats successeful");
            return getOperationTrackerXml();
        } catch (Exception e) {
            log.error("Unable to perform ./xml-api/api/stats", e.getMessage());
            return null;
        }
    }

    private OperationTracker getOperationTrackerXml() throws FileNotFoundException, JAXBException {
        JAXBContext jc = JAXBContext.newInstance(OperationTracker.class);
        File xml = new File("src/main/java/org/workfully/database/OperationTracker.xml");
        return (OperationTracker) jc.createUnmarshaller()
                .unmarshal(new FileReader(xml));
    }
}