package org.workfully.controllers;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class OperationTrackerDBController {

    private static final String FILE_PATH = "src/main/java/org/workfully/database/OperationTrackerDB.xml";

    public static Document getXmlDB() {
        try {

            File inputFile = new File("src/main/java/org/workfully/database/OperationTrackerDB.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document document = dBuilder.parse(inputFile);

            return document;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateStat(String statProp){
        try {
            Document xmlDocument = OperationTrackerDBController.getXmlDB();

            Node elemment = xmlDocument.getElementsByTagName(statProp).item(0);
            // Node elemment = xmlDocument.getElementsByTagName("pageReaquests").item(0);

            int statPreviousValue = Integer.parseInt(elemment.getTextContent());
            elemment.setTextContent(Integer.toString(statPreviousValue + 1));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(xmlDocument);
            StreamResult result = new StreamResult(new File(OperationTrackerDBController.FILE_PATH));
            transformer.transform(source, result);

            // For console Output.
            // 🐞
            // StreamResult consoleResult = new StreamResult(System.out);
            // transformer.transform(source, consoleResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // updateGetProductsStat();
        // System.out.print(getXmlDB().get);
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
