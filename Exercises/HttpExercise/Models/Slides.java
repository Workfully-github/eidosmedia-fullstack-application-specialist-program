package HttpExercise.Models;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Slides {
    
    private String title;
    private String type;
    private ArrayList<String> items;
    private JSONObject json;

    public Slides(JSONObject json) {
        this.json = json;
        title = json.getString("title");
        type = json.getString("type");

        if(json.has("items"))
            items = parseSlideItems(json.getJSONArray("items"));
    }

    private ArrayList<String> parseSlideItems(JSONArray jsonArray) {

        ArrayList<String> items = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            items.add(jsonArray.getString(i));
        }

        return items;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ArrayList<Slides> getSlides(JSONArray jsonArray) {
        
        ArrayList<Slides> slides = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            slides.add(new Slides(jsonArray.getJSONObject(i)));
        }
        
        return slides;
    }
}
