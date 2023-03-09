package org.workfully.http;

import org.json.JSONArray;
import org.json.JSONObject;
import org.workfully.models.Product;
import org.workfully.models.Stats;

public class APIController {

    private final String BASE_URL = "http://localhost:8080/dummy-api/products";
    private final String ORIGINAL_URL = "https://dummyjson.com/products";
    private final String CATEGORY_FEATURE = "/category";
    private final String CATEGORIES_RESOURCE = "http://localhost:8080/dummy-api/categories";
    private RestController rest;

    public APIController() {
        this.rest = new RestController();
    }

    private JSONArray response(String request) {
        JSONObject json = new JSONObject(rest.getBody(request));
        return json.getJSONArray("products");
    }

    public JSONArray requestProductList(String request) {
        return response(request);
    }

    public int getTotalPages() {
        JSONObject json = new JSONObject(rest.getBody(this.BASE_URL));
        return json.getInt("total");
    }

    public Product getProduct(int id) {
        return new Product(new JSONObject(rest.getBody(this.BASE_URL + "/" + id)));
    }

    public JSONArray getCategoryList() {
        return new JSONArray(rest.getBody(this.CATEGORIES_RESOURCE));
    }

    public JSONArray getProductsByCategory(String category) {
        JSONObject json = new JSONObject(rest.getBody(this.BASE_URL + this.CATEGORY_FEATURE + "/" + category));
        return json.getJSONArray("products");
    }

    public Stats getStats() {

        return new Stats(new JSONObject());
    }
}
