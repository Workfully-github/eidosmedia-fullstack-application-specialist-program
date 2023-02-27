package org.workfully.models;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.w3c.dom.*;
import org.json.JSONObject;

public class Slideshow {

    private String title;
    private String author;
    private String date;
    private ArrayList<Slides> slides;

    public Slideshow(Document xml) {
        Element root = xml.getDocumentElement();
        NamedNodeMap attributes = root.getAttributes();
        this.title = attributes.getNamedItem("title").getNodeName();
        this.author = attributes.getNamedItem("author").getNodeName();
        this.date = attributes.getNamedItem("date").getNodeName();
        this.slides = new ArrayList<Slides>(){
            {
                for (int i = 0; i < root.getElementsByTagName("slide").getLength(); i++) {
                    add(new Slides((Element) root.getElementsByTagName("slide").item(i)));
                }
            }
        };
    }

    /**
     * @param json refers to the key "Slideshow"
     */
    public Slideshow(JSONObject json) {
        this.title = json.getString("title");
        this.author = json.getString("author");
        this.date = json.getString("date");
        this.slides = new ArrayList<Slides>() {
            {
                for (Object slide : json.getJSONArray("slides")) {
                    add(new Slides((JSONObject) slide));
                }
            }
        };
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

/*
 * {
 * "slideshow": {
 * "author": "Yours Truly",
 * "date": "date of publication",
 * "slides": [
 * {
 * "title": "Wake up to WonderWidgets!",
 * "type": "all"
 * },
 * {
 * "items": [
 * "Why <em>WonderWidgets</em> are great",
 * "Who <em>buys</em> WonderWidgets"
 * ],
 * }
 * }
 */