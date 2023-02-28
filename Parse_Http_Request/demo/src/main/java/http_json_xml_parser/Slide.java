package http_json_xml_parser;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Slide {
    private String title;
    private String type;
    private ArrayList<String> items;

    public Slide(JSONObject slide){
        this.title =  slide.getString("title");
        this.type =  slide.getString("type");
        if(slide.has("items")) 
            this.items = getItems(slide.getJSONArray("items"));
    }

    public Slide(Element slide){
        this.title =  slide.getElementsByTagName("title").item(0).getTextContent();
        this.type =  slide.getAttribute("type");
            this.items = getItems(slide.getElementsByTagName("item"));
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(String item) {
        this.items.add(item);
    }

    public ArrayList<String> getSlidesItems() {
        return items;
    }
    private ArrayList<String> getItems(JSONArray items) {
        ArrayList<String> itemsArr = new ArrayList<>();

        for(int i = 0 ; i < items.length(); i++){
            itemsArr.add(items.get(i).toString());
        }
        return itemsArr;
    }

    private ArrayList<String> getItems(NodeList items) {
        ArrayList<String> itemsArr = new ArrayList<>();

        for(int i = 0 ; i < items.getLength(); i++){
            String item =  items.item(i).getTextContent();
            itemsArr.add(item);
        }
        return itemsArr;
    }

}
