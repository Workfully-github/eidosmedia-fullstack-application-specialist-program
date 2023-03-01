package org.workfully.utilities;

import org.json.JSONArray;
import org.json.JSONObject;
import org.workfully.view.ProductList;

public class Paginator {

    ProductList productList;

    public static JSONArray selectPage(int pageSelection) {

        int pageNumber = pageSelection - 1;
        int skip = pageNumber * 30;
        JSONObject json = new JSONObject(
                RestController.getBody("https://dummyjson.com/products?skip=" + skip + "&limit=30"));
        return json.getJSONArray("products");

    }

}
