package org.workfully.controllers;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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

        try {
            OperationTrackerDBController operationTrackerDBController = new OperationTrackerDBController();

            Document xmlDocument = operationTrackerDBController.getXmlDB();
    
            Node elemment = xmlDocument.getElementsByTagName("productsCounter").item(0);
            
            elemment.setTextContent("10"); //<---- 
    
            TransformerFactory transformerFactory = 
                          TransformerFactory.newInstance();
            Transformer transformer=
                                   transformerFactory.newTransformer();
            DOMSource source = new DOMSource(xmlDocument);
            StreamResult result=new StreamResult(new File(operationTrackerDBController.FILE_PATH));
            transformer.transform(source, result);
     
            //For console Output.
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);	


        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }
}
