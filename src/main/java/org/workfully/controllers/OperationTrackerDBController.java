package org.workfully.controllers;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class OperationTrackerDBController {

    private final String FILE_PATH = "src/main/java/org/workfully/database/OperationTrackerDB.xml";

    public Document getXmlDB() {
        try {

            File inputFile = new File(FILE_PATH);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document document = dBuilder.parse(inputFile);

            return document;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {

        OperationTrackerDBController operationTrackerDBController = new OperationTrackerDBController();

        Node elemment = operationTrackerDBController.getXmlDB().getElementsByTagName("productsCounter").item(0);
        System.out.println(elemment.getTextContent());
        elemment.setTextContent("5");
    }
}
