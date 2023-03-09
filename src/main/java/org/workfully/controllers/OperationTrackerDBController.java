package org.workfully.controllers;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.workfully.resources.UpdateStats;

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

    public static void main(String[] args) {
        updateStat("pageReaquests");
    }

    public static void updateStat(String statProp){
        try {

            Document xmlDocument = OperationTrackerDBController.getXmlDB();

            
            NodeList elemments = xmlDocument.getElementsByTagName("stat");


            for(int i = 0; i < elemments.getLength(); i++){
                
                if(((Element) elemments.item(i)).getAttribute("class").equals(statProp)) {
                    int statPreviousValue = Integer.parseInt(elemments.item(i).getTextContent());
                    elemments.item(i).setTextContent(Integer.toString(statPreviousValue + 1));
                    System.out.println(elemments.item(i).getTextContent());
                }
            }
            
            // Node elemment = xmlDocument.getElementsByTagName("pageReaquests").item(0);


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
