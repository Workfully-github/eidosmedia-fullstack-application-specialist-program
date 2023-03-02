package org.workfully.sandboxes;

import org.json.JSONArray;
import org.json.JSONObject;
import org.workfully.utilities.RestController;

public class Bootstrap {

    public static JSONObject JSON_MAIN = new JSONObject((RestController.getBody("https://dummyjson.com/products")));
    public static JSONArray PRODUCTS = JSON_MAIN.getJSONArray("products");
    
}
