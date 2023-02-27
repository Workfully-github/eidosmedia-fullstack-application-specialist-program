package HttpRest.Models;


import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class Slide {
    private String title;
    private String type;
    private List<String> items = new ArrayList<>();


    public Slide(JSONObject json) {
        try{
            this.title = json.getString("title");
        }
        catch (Exception e){
            this.title ="";
        }

        try{
            this.type = json.getString("type");
        }
        catch (Exception e){
            this.type ="";
        }

        try{
            JSONArray itemsJson = json.getJSONArray("items");
            for (int i = 0; i < itemsJson.length(); i++) {
                String item = itemsJson.getString(i);
                this.items.add(item);
            }
        }
        catch (Exception e){
        }
    }

    public Slide(Element element) {
        this.title = element.getElementsByTagName("title").item(0).getTextContent();
        this.type = element.getElementsByTagName("type").item(0).getTextContent();

        NodeList itemsList = element.getElementsByTagName("item");
        for (int i = 0; i < itemsList.getLength(); i++) {
            String item = itemsList.item(i).getTextContent();
            this.items.add(item);
        }
    }

    public Slide(String title, String type, List<String> items) {
        this.title = title;
        this.type = type;
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}