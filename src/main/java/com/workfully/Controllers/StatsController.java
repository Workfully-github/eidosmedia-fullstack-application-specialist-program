package com.workfully.Controllers;

import java.util.ArrayList;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.workfully.Models.Stat;

public class StatsController {
    private Stat stat;


    public JSONObject parseXmlToJson(Document xmlData) {
        JSONObject jsonData = new JSONObject();
        jsonData.put("stats", new JSONObject());


        NodeList elemments = xmlData.getElementsByTagName("stat");

            for (int i = 0; i < elemments.getLength(); i++) {
                jsonData.getJSONObject("stats")
                .put(((Element) elemments.item(i))
                .getAttribute("class"), 
                elemments.item(i).getTextContent());
            }

        return jsonData;
    }

    
}
