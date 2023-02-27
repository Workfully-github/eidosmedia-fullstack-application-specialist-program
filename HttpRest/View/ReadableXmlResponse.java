package HttpRest.View;

import HttpRest.Models.Slide;
import HttpRest.Models.Slideshow;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadableXmlResponse {

    public static void print(String xml) throws Exception {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(xml.getBytes());
            Document doc = dBuilder.parse(inputStream);

            doc.getDocumentElement().normalize();

            Element slideshowElement = (Element) doc.getElementsByTagName("slideshow").item(0);

            String title = slideshowElement.getAttribute("title");
            String author = slideshowElement.getAttribute("author");
            String date = slideshowElement.getAttribute("date");

            Slideshow slideshow = new Slideshow(title, author, date);

            NodeList slideNodeList = doc.getElementsByTagName("slide");
            List<Slide> slides = new ArrayList<>();

            for (int i = 0; i < slideNodeList.getLength(); i++) {
                Node slideNode = slideNodeList.item(i);
                if (slideNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element slideElement = (Element) slideNode;
                    String type = slideElement.getAttribute("type");
                    String slideTitle = slideElement.getElementsByTagName("title").item(0).getTextContent();

                    NodeList itemNodeList = slideElement.getElementsByTagName("item");
                    List<String> items = new ArrayList<>();
                    for (int j = 0; j < itemNodeList.getLength(); j++) {
                        Node itemNode = itemNodeList.item(j);
                        if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element itemElement = (Element) itemNode;
                            String itemText = itemElement.getTextContent();
                            items.add(itemText);
                        }
                    }

                    Slide slide = new Slide(slideTitle, type, items);
                    slides.add(slide);
                }
            }

            slideshow.setSlides(slides);

            System.out.println("title : " + slideshow.getTitle());
            System.out.println("Author : " + slideshow.getAuthor());
            System.out.println("date :" + slideshow.getDate());
            System.out.println("Slides :");

            for (Slide slide : slideshow.getSlides()) {
                System.out.println("---title : " + slide.getTitle());
                System.out.println("---type : " + slide.getType());
                System.out.println("---Items : ");
                if (slide.getItems() != null) {
                    for (String item : slide.getItems()) {
                        System.out.println("----- "  + item);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
