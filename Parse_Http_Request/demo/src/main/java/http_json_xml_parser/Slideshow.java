package http_json_xml_parser;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Slideshow {
    String title;
    String author;
    String date;
    ArrayList<Slide> slides = new ArrayList<>();;

    public Slideshow(JSONObject slideshowObj){
        this.title = slideshowObj.getString("title");
        this.author = slideshowObj.getString("author");
        this.date = slideshowObj.getString("date");

        // this.slides = getSlides(slideshowObj.getJSONArray("slides"));
        this.slides = getSlides(slideshowObj.getJSONArray("slides"));
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
   
}
