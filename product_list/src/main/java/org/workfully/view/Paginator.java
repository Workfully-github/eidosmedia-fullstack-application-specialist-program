package org.workfully.view;

import org.json.JSONArray;
import org.json.JSONObject;
import org.workfully.utilities.RestController;

public class Paginator {

    ProductList productList;

    public JSONArray selectPage(int pageNumber) {

        int skip = pageNumber * 30;
        JSONObject json = new JSONObject(
                RestController.getBody("https://dummyjson.com/products?skip=" + skip + "&limit=30"));
        return json.getJSONArray("products");

    }

}
