package org.workfully.models;

import java.util.ArrayList;

import org.json.JSONObject;

public class Slideshow {

    private String title;
    private String author;
    private String date;
    private ArrayList<Slides> slides;

    /**
     * @param json refers to the key "Slideshow"
     */
    public Slideshow(JSONObject json) {
        this.title = json.get("title").toString();
        this.author = json.get("author").toString();
        this.date = json.get("date").toString();
        this.slides = new ArrayList<Slides>(){
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


/* {
    "slideshow": {
      "author": "Yours Truly", 
      "date": "date of publication", 
      "slides": [
        {
          "title": "Wake up to WonderWidgets!", 
          "type": "all"
        },
        {
          "items": [
            "Why <em>WonderWidgets</em> are great",
            "Who <em>buys</em> WonderWidgets"
          ],
    }
  } */