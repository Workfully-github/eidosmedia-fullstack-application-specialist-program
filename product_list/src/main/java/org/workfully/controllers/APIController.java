package org.workfully.controllers;

import org.json.JSONArray;
import org.json.JSONObject;
import org.workfully.http.RestController;
import org.workfully.models.Product;

public class APIController {

    private final String BASE_URL = "https://dummyjson.com/products";
    private final String CATEGORY_FEATURE = "/category";
    private final String CATEGORIES_RESOURCE = "/categories";
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
        return new Product(new JSONObject(rest.getBody(BASE_URL + "/" + id)));
    }

    protected JSONArray getCategoryList() {
        return new JSONArray(rest.getBody(this.BASE_URL + CATEGORIES_RESOURCE));
    }

    public JSONArray getProductsByCategory(String category) {
        JSONObject json = new JSONObject(rest.getBody(this.BASE_URL + CATEGORY_FEATURE + "/" + category));
        return json.getJSONArray("products");
    }


}
