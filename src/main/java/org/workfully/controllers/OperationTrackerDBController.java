package org.workfully.controllers;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class OperationTrackerDBController {

    private static final Logger log = LogManager.getLogger(OperationTrackerDBController.class);
    private static final String FILE_PATH = "src/main/java/org/workfully/database/OperationTrackerDB.xml";
    private static final String SUCCESS_MESSAGE = "Retrieved XML Successfuly";

    public static Document getXmlDB() {
        try {

            File inputFile = new File("src/main/java/org/workfully/database/OperationTrackerDB.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document document = dBuilder.parse(inputFile);

            log.info(SUCCESS_MESSAGE);

            return document;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        updateStat("pageReaquests");
    }

    public static void updateStat(String statProp) {
        try {

            Document xmlDocument = OperationTrackerDBController.getXmlDB();

            NodeList elemments = xmlDocument.getElementsByTagName("stat");

            for (int i = 0; i < elemments.getLength(); i++) {

                if (((Element) elemments.item(i)).getAttribute("class").equals(statProp)) {
                    int statPreviousValue = Integer.parseInt(elemments.item(i).getTextContent());
                    elemments.item(i).setTextContent(Integer.toString(statPreviousValue + 1));
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(xmlDocument);
            StreamResult result = new StreamResult(new File(OperationTrackerDBController.FILE_PATH));
            transformer.transform(source, result);

            log.info(SUCCESS_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            log.warn("FAILED TO UPDATE STATUS", e);
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
