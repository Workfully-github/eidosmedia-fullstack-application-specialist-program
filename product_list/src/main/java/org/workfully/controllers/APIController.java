package org.workfully.controllers;

import org.json.JSONArray;
import org.json.JSONObject;
import org.workfully.http.RestController;
import org.workfully.models.Product;

public class APIController {

    private final String BASE_URL = "https://dummyjson.com/products";
    private final String CATEGORY_FEATURE = "/category";
    private RestController rest;


    public APIController() {
        this.rest = new RestController();
    }

/*     public JSONArray getAllProducts(int pageSelection, int valuesPerPage) {
        this.pageSelection = pageSelection;
        this.pageIndex = pageSelection - 1;
        this.valuesPerPage = valuesPerPage;
        this.skip = pageIndex * valuesPerPage;
        return makeProductsJSONArray();
    } */

    public JSONArray getEverything() {
        JSONObject json = new JSONObject(rest
                .getBody(this.BASE_URL));

        return json.getJSONArray("products");
    }

/*     public JSONArray getAllProducts(int pageSelection) {
        this.pageSelection = pageSelection;
        this.pageIndex = this.pageSelection - 1;
        this.valuesPerPage = 30;
        this.skip = pageIndex * valuesPerPage;
        return makeProductsJSONArray();
    } */

    public JSONArray getAllProducts(String request) {
        return makeProductsJSONArray(request);
    }

    public int getTotalPages() {
        JSONObject json = new JSONObject(rest
        .getBody(this.BASE_URL));

        return json.getInt("total");
    }

    public JSONArray nextPage(String request) {
        return makeProductsJSONArray(request);
    }

    public JSONArray returnPage(String request) {
        return makeProductsJSONArray(request);
    }

    public Product getProduct(int id) {
        return new Product(new JSONObject(rest.getBody(BASE_URL + "/" + id)));
    }

    public JSONArray getCategoryList(String endpoint) {
        return new JSONArray(rest
                .getBody(this.BASE_URL + endpoint));
    }

    public JSONArray getProductsByCategory(String category) {
        JSONObject json = new JSONObject(rest
                .getBody(this.BASE_URL + CATEGORY_FEATURE + "/" + category));

        return json.getJSONArray("products");
    }

    /**
     * @param keyword for searching products by keyword
     *                query not encapsulated since it has unique structure
     */
    public JSONArray getProductsByKeyword(String request) {
        JSONObject json = new JSONObject(rest
                .getBody(request));

        return json.getJSONArray("products");
    }


    /**
     * Helper method, used in pagination
     * {@link #nextPage()}
     * {@link #returnPage()}
     * {@link #selectPage(int pageSelection, int valuesPerPage)}
     * {@link #selectPage(int pageSelection)}
     */
    private JSONArray makeProductsJSONArray(String request) {
        JSONObject json = new JSONObject(
                rest.getBody(request));
        return json.getJSONArray("products");
    }
}
