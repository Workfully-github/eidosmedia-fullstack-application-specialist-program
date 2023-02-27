package HttpRest.Models;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class Slideshow {
    private String title;
    private String author;
    private String date;
    private List<Slide> slides = new ArrayList();

    public Slideshow(JSONObject json) {

        JSONObject SlideshowJson = json.getJSONObject("slideshow");
        //System.out.println(json.toString(2));
        this.title = SlideshowJson.getString("title");
        this.author = SlideshowJson.getString("author");
        this.date = SlideshowJson.getString("date");

        JSONArray slidesJson = SlideshowJson.getJSONArray("slides");

        for (int i = 0; i < slidesJson.length(); i++) {
            JSONObject jsonObjectSlide = slidesJson.getJSONObject(i);
            this.slides.add(new Slide(jsonObjectSlide));
        }
    }

    public Slideshow(String title, String author, String date) {
        this.title = title;
        this.author = author;
        this.date = date;
    }

    public Slideshow(Element element) {

        this.title = element.getElementsByTagName("title").item(0).getTextContent();
        this.author = element.getElementsByTagName("author").item(0).getTextContent();
        this.date = element.getElementsByTagName("date").item(0).getTextContent();

        NodeList slidesList = element.getElementsByTagName("slide");

        for (int i = 0; i < slidesList.getLength(); i++) {
            Element slideElement = (Element) slidesList.item(i);
            this.slides.add(new Slide(slideElement));
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Slide> getSlides() {
        return slides;
    }

    public void setSlides(List<Slide> slides) {
        this.slides = slides;
    }
}

