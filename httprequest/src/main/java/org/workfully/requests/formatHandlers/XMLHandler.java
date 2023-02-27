package org.workfully.requests.formatHandlers;

import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class XMLHandler {

    public static void parse(String xmlString) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlString)));
            Element root = document.getDocumentElement();
    
            // Print XML version and encoding
            System.out.println("XML version: " + document.getXmlVersion());
            System.out.println("Encoding: " + document.getXmlEncoding());
    
            // Print main key and attributes
            System.out.println("Main Key: " + root.getNodeName());
            NamedNodeMap attributes = root.getAttributes();
            for (int i = attributes.getLength()-1; i >= 0; i--) {
                Node attribute = attributes.item(i);
                System.out.println(attribute.getNodeName() + ": " + attribute.getNodeValue());
            }
    
            // Print slides and items
            NodeList slideNodes = root.getElementsByTagName("slide");
            for (int i = 0; i < slideNodes.getLength(); i++) {
                Element slide = (Element) slideNodes.item(i);
                System.out.println("type: " + slide.getAttribute("type"));
                System.out.println("title: " + slide.getElementsByTagName("title").item(0).getTextContent());
    
                NodeList itemNodes = slide.getElementsByTagName("item");
                for (int k = 0; k < itemNodes.getLength(); k++) {
                    Element item = (Element) itemNodes.item(k);
                    String itemText = item.getTextContent().replaceAll("<.*?>", "");
                    System.out.println("item[" + k + "]: " + (itemText.isEmpty() ? " " : itemText));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
