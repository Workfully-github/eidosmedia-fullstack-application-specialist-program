package http_json_xml_parser;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Slideshow {
    String title;
    String author;
    String date;
    ArrayList<Slide> slides = new ArrayList<>();;

    public Slideshow(JSONObject slideshowObj){
        this.title = slideshowObj.getString("title");
        this.author = slideshowObj.getString("author");
        this.date = slideshowObj.getString("date");

        this.slides = getSlides(slideshowObj.getJSONArray("slides"));
    }

    public Slideshow(org.w3c.dom.Document slideshowXml){
        this.title = slideshowXml.getDocumentElement().getAttribute("title");
        this.author = slideshowXml.getDocumentElement().getAttribute("author");
        this.date = slideshowXml.getDocumentElement().getAttribute("date");

        this.slides = getSlides(slideshowXml.getDocumentElement().getElementsByTagName("slide"));
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public ArrayList<Slide> getSlides() {
        return slides;
    }
    

    private ArrayList<Slide> getSlides(JSONArray slides) {

        for(int i = 0 ; i < slides.length(); i++){
            this.slides.add(  new Slide(slides.getJSONObject(i)));
        }
        return this.slides;
    }

    private ArrayList<Slide> getSlides(NodeList slides) {
        System.out.println("sdfgh");
        
        for(int i = 0 ; i < slides.getLength(); i++){
            Element item = (Element) slides.item(i);
            System.out.print(item.getAttribute("type"));
            System.out.print(item.getElementsByTagName("title").item(0).getTextContent());
            this.slides.add(new Slide(item));
        }
        return this.slides;
    }
   
}
