package org.workfully;

import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class XMLParser {

    public static void parse(String xmlString) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            Document doc = factory.newDocumentBuilder().parse(new InputSource(new StringReader(xmlString)));

            Element root = doc.getDocumentElement();
            System.out.println("Main Key: " + root.getTagName());

            NodeList slides = root.getElementsByTagName("slide");
            for (int i = 0; i < slides.getLength(); i++) {
                Element slide = (Element) slides.item(i);
                System.out.println("Title: " + slide.getElementsByTagName("title").item(0).getTextContent());
                NodeList items = slide.getElementsByTagName("item");
                for (int j = 0; j < items.getLength(); j++) {
                    Element item = (Element) items.item(j);
                    String itemValue = item.getTextContent().replaceAll("<.*?>", "");
                    if (!itemValue.isEmpty()) {
                        System.out.println("Item: " + itemValue);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
