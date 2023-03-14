package org.workfully.controllers;

import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.workfully.model.OperationTracker;

public class OperationTrackerController {

    private static final Logger log = LogManager.getLogger(OperationTrackerController.class.getName());
    private static final String FILE_PATH = "src/main/java/org/workfully/database/OperationTracker.xml";
    private static OperationTracker ot;

    /**
     * Updates model with
     * {@link src/main/java/org/workfully/database/OperationTracker.xml}
     */
    public OperationTrackerController() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(OperationTracker.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            File file = new File(FILE_PATH);
            ot = (OperationTracker) unmarshaller.unmarshal(file);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public void incrementPageRequests() {
        try {
            ot.incrementPageRequests();
            saveToFile(FILE_PATH);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public void incrementAllProductsRequests() {
        try {
            ot.incrementAllProductsRequests();
            saveToFile(FILE_PATH);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public void incrementProductDetailsRequests() {
        try {
            ot.incrementProductDetailsRequests();
            saveToFile(FILE_PATH);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public void incrementSearchRequests() {
        try {
            ot.incrementSearchRequests();
            saveToFile(FILE_PATH);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public void incrementSearchByCategoryRequests() {
        try {
            ot.incrementSearchByCategoryRequests();
            saveToFile(FILE_PATH);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public void incrementCategoriesRequests() {
        try {
            ot.incrementCategoriesRequests();
            saveToFile(FILE_PATH);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public void saveToFile(String filePath) throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(OperationTracker.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(ot, new File(filePath));
    }
}
