package org.workfully;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONHandler {

    private static JSONParser parser = new JSONParser();

    public static void jsonReader(String jsonStr) {
        try {
            JSONObject mainObj = (JSONObject) parser.parse(jsonStr);
            String mainKey = (String) mainObj.keySet().toArray()[0];
            JSONObject slideshowObj = (JSONObject) mainObj.get(mainKey);

            System.out.println("Main Key: " + mainKey);
            System.out.println("author: " + slideshowObj.get("author"));
            System.out.println("date: " + slideshowObj.get("date"));
            System.out.println("title: " + slideshowObj.get("title"));

            JSONArray slidesArr = (JSONArray) slideshowObj.get("slides");
            for (Object slideObj : slidesArr) {
                System.out.println("title: " + ((JSONObject) slideObj).get("title"));
                System.out.println("type: " + ((JSONObject) slideObj).get("type"));

                JSONArray itemsArr = (JSONArray) ((JSONObject) slideObj).get("items");
                if (itemsArr != null) {
                    System.out.println("items: " + String.join(", ", cleanItems(itemsArr)));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /*
     * Cleans array brackets and html tags;
     */
    private static String[] cleanItems(JSONArray itemsArr) {
        String[] items = new String[itemsArr.size()];
        for (int i = 0; i < itemsArr.size(); i++) {
            items[i] = ((String) itemsArr.get(i)).replaceAll("<em>|</em>", "");
        }
        return items;
    }

}
