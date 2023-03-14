package org.workfully.controllers;


import org.json.JSONObject;
import org.w3c.dom.Document;
import org.workfully.model.OperationTracker;

// import org.workfully.Models.Stats;

public class StatsController {

    public JSONObject getStats(Document xmlData) {
        JSONObject jsonData = new JSONObject();
        jsonData.put("stats", new JSONObject());

        OperationTracker ot = new OperationTracker();

        

        jsonData.getJSONObject("stats").put("pageRequests", ot.getPageRequests());
        jsonData.getJSONObject("stats").put("allProductsRequests", ot.getAllProductsRequests());
        jsonData.getJSONObject("stats").put("productDetailsRequests", ot.getProductDetailsRequests());
        jsonData.getJSONObject("stats").put("searchRequests", ot.getSearchRequests());
        jsonData.getJSONObject("stats").put("searchByCategoryRequests", ot.getSearchByCategoryRequests());
        jsonData.getJSONObject("stats").put("categoriesRequests", ot.getCategoriesRequests());

       
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
