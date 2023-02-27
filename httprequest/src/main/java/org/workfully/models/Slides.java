package org.workfully.models;

import java.util.ArrayList;

import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public class Slides {

    private String title;
    private String type;
    private ArrayList<String> items;

    public Slides(Element slide) {
        this.title = slide.getAttribute("title");
        this.type = slide.getAttribute("type");
        if(slide.getElementsByTagName("item") != null){
            this.items = new ArrayList<String>() {
                {
                    for (int i = 0; i < slide.getElementsByTagName("item").getLength(); i++) {
                        add((String) slide.getElementsByTagName("item").item(i).getTextContent());
                    }
                }
            };
        }
    }

    public Slides(JSONObject json) {
        this.title = json.getString("title");
        this.type = json.getString("type");
        if (json.has("items")) {
            this.items = new ArrayList<String>() {
                {
                    for (Object string : json.getJSONArray("items")) {
                        add((String) string);
                    }
                }
            };
        }
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

    public ArrayList<String> getItems() {
        return items;
    }
}

/*
 * {
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
 * "title": "Overview",
 * "type": "all"
 * }
 * ],
 * }
 */