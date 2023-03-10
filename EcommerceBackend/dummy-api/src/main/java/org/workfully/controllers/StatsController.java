package org.workfully.controllers;


import org.json.JSONObject;
import org.w3c.dom.Document;
import org.workfully.models.Stats;

// import org.workfully.Models.Stats;

public class StatsController {

    public JSONObject getStats(Document xmlData) {
        JSONObject jsonData = new JSONObject();
        jsonData.put("stats", new JSONObject());

        Stats stats = new Stats(xmlData);

        jsonData.getJSONObject("stats").put("pageRequests", stats.getPageRequests());
        jsonData.getJSONObject("stats").put("allProductsRequests", stats.getAllProductsRequests());
        jsonData.getJSONObject("stats").put("productDetailsRequests", stats.getProductDetailsRequests());
        jsonData.getJSONObject("stats").put("searchRequests", stats.getSearchRequests());
        jsonData.getJSONObject("stats").put("searchByCategoryRequests", stats.getSearchByCategoryRequests());
        jsonData.getJSONObject("stats").put("categoriesRequests", stats.getCategoriesRequests());

       
        return jsonData;
    }

    //  UNCOMMENT TO IGNORE THE MODEL

    // public JSONObject getStats(Document xmlData) {
    //     JSONObject jsonData = new JSONObject();
    //     jsonData.put("stats", new JSONObject());

    //     Stats stats = new Stats(xmlData);
    //     // stats.get
    //     NodeList elemments = xmlData.getElementsByTagName("stat");
    //         for (int i = 0; i < elemments.getLength(); i++) {
    //             jsonData.getJSONObject("stats")
    //             .put(((Element) elemments.item(i))
    //             .getAttribute("class"), 
    //             elemments.item(i).getTextContent());
    //         }
    //     return jsonData;
    // }


    
}
