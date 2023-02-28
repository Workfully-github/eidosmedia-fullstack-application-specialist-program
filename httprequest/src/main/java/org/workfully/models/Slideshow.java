package org.workfully.models;

import java.util.ArrayList;

import org.w3c.dom.*;
import org.json.JSONObject;

public class Slideshow {

    private String title;
    private String author;
    private String date;
    private ArrayList<Slides> slides;
    private boolean json;

    public Slideshow(Document xml, String contentType) {
        System.out.println(contentType);
        if (contentType.contains("application/xml")) {
            Element root = xml.getDocumentElement();
            NamedNodeMap attributes = root.getAttributes();
            this.title = attributes.getNamedItem("title").getNodeName();
            this.author = attributes.getNamedItem("author").getNodeName();
            this.date = attributes.getNamedItem("date").getNodeName();
            this.slides = Slides.parseSlides(root);
            this.json = false;
        }
    }

    /**
     * @param json refers to the key "Slideshow"
     */
    public Slideshow(JSONObject json, String contentType) {
        if (contentType.contains("application/json")) {
            this.title = json.getString("title");
            this.author = json.getString("author");
            this.date = json.getString("date");
            this.slides = Slides.parseSlides(json);
            this.json = true;
        }
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

    public ArrayList<Slides> getSlides() {
        return slides;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSlides(ArrayList<Slides> slides) {
        this.slides = slides;
    }

}