package HttpExercise.Models;

import java.util.ArrayList;

import org.w3c.dom.*;

import org.json.JSONObject;

public class SlideShow {
    
    private String author;
    private String date;
    private String title;
    private ArrayList<Slides> slide = new ArrayList<>();
    private JSONObject json;
    private Document doc;

    public SlideShow(JSONObject json) {
        this.json = json;
        title = json.getString("title");
        date = json.getString("date");
        author = json.getString("author");
        slide = Slides.getSlides(json.getJSONArray("slides"));
    }

    public SlideShow(org.w3c.dom.Document doc) {
        this.doc = doc;
        title = doc.getDocumentElement().getAttribute("title");
        date = doc.getDocumentElement().getAttribute("date");
        author = doc.getDocumentElement().getAttribute("author");
        slide = Slides.getSlidesXML(doc.getElementsByTagName("slide"));
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSlide(ArrayList<Slides> slide) {
        this.slide = slide;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public ArrayList<Slides> getSlide() {
        return slide;
    }

    public String getTitle() {
        return title;
    }
}
