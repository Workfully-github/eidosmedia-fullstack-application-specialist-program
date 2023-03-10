package org.workfully.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class OperationTrackerDBController {

    private static final Logger log = LogManager.getLogger(OperationTrackerDBController.class);
    private static final String FILE_PATH = "src/main/java/org/workfully/database/OperationTrackerDB.xml";
    private static final String SUCCESS_MESSAGE = "Returned XML Successfuly";
    private static final String FAIL_MESSAGE = "Failed to return XML";
    private static final String FAILED_UPDATE = "Failed to update status";

    public static Document getXmlDB() {
        try {
            File inputFile = new File(FILE_PATH);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(inputFile);
            log.info(SUCCESS_MESSAGE);
            return document;

        } catch (Exception e) {
            log.warn(FAIL_MESSAGE);
            return null;
        }
    }

    public static void updateStat(String statToUpdate) {
        try {
            Document xmlDocument = updateAndReturnDocument(statToUpdate);
            saveXMLDocument(xmlDocument);
            log.info(SUCCESS_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            log.warn(FAILED_UPDATE, e);
        }
    }

    private static Document updateAndReturnDocument(String statToUpdate) {
        Document xmlDocument = OperationTrackerDBController.getXmlDB();
        NodeList elements = xmlDocument.getElementsByTagName("stat");

        for (int i = 0; i < elements.getLength(); i++) {
            if (((Element) elements.item(i)).getAttribute("class").equals(statToUpdate)) {
                int statPreviousValue = Integer.parseInt(elements.item(i).getTextContent());
                elements.item(i).setTextContent(Integer.toString(statPreviousValue + 1));
            }
        }

        return xmlDocument;
    }

    private static void saveXMLDocument(Document xmlDocument) throws TransformerException, IOException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(xmlDocument);

        try (FileOutputStream outputStream = new FileOutputStream(OperationTrackerDBController.FILE_PATH)) {
            StreamResult result = new StreamResult(outputStream);
            transformer.transform(source, result);
        }
    }

    public void updateGetProductsStat() {
        updateStat("pageReaquests");
    }

    public void updateGetAllProductsStat() {
        updateStat("allProductsRequests");
    }

    public void updateGetProductStat() {
        updateStat("productDetailsRequests");
    }

    public void updateSearchCounterStat() {
        updateStat("searchRequests");
    }

    public void updateSearchByCategoryStat() {
        updateStat("searchByCategoryRequests");
    }

    public void updateGetCategoriesStat() {
        updateStat("categoriesRequests");
    }
}
