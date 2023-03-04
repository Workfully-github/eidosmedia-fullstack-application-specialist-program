package org.workfully.controllers;

import org.json.JSONArray;
import org.json.JSONObject;
import org.workfully.http.RestController;
import org.workfully.models.Product;

public class APIController {

    private final String BASE_URL = "https://dummyjson.com/products";
    private final String CATEGORY_FEATURE = "/category";
    private final String SEARCH_FEATURE = "/search?q=";
    private RestController rest;
    private JSONObject json;
    private int pageSelection;
    private int pageIndex;
    private int skip;
    private int valuesPerPage;

    public APIController() {
        this.rest = new RestController();
    }

    public JSONArray getAllProducts(int pageSelection, int valuesPerPage) {
        this.pageSelection = pageSelection;
        this.pageIndex = pageSelection - 1;
        this.valuesPerPage = valuesPerPage;
        this.skip = pageIndex * valuesPerPage;
        return makeProductsJSONArray();
    }

    public JSONArray getAllProducts(int pageSelection) {
        this.pageSelection = pageSelection;
        this.pageIndex = this.pageSelection - 1;
        this.valuesPerPage = 30;
        this.skip = pageIndex * valuesPerPage;
        return makeProductsJSONArray();
    }

    public JSONArray getAllProducts() {
        this.pageSelection = 1;
        this.pageIndex = this.pageSelection - 1;
        this.valuesPerPage = 30;
        this.skip = pageIndex * valuesPerPage;
        return makeProductsJSONArray();
    }

    public int getTotalPages() {
        return this.json.getInt("total");
    }

    public int getPagesLeft() {
        int limit = this.json.getInt("limit");
        return (getTotalPages() / limit) - this.pageSelection;
    }

    public JSONArray nextPage() {
        this.pageIndex++;
        this.pageSelection = this.pageIndex + 1;
        this.skip = this.pageIndex * this.valuesPerPage;
        return makeProductsJSONArray();
    }

    public JSONArray returnPage() {
        this.pageIndex--;
        this.pageSelection = this.pageIndex + 1;
        this.skip = this.pageIndex * this.valuesPerPage;
        return makeProductsJSONArray();
    }

    public int getPageSelection() {
        return this.pageSelection;
    }

    public Product getProduct(int id) {
        return new Product(new JSONObject(rest.getBody(BASE_URL + "/" + id)));
    }

    public JSONArray getCategoryList(String endpoint) {
        return new JSONArray(rest
                .getBody(this.BASE_URL + endpoint));
    }

    public JSONArray getProductsByCategory(String category) {
        this.json = new JSONObject(rest
                .getBody(this.BASE_URL + CATEGORY_FEATURE + "/" + category));

        return json.getJSONArray("products");
    }

    /**
     * @param keyword for searching products by keyword
     *                query not encapsulated since it has unique structure
     */
    public JSONArray getProductsByKeyword(String keyword) {
        this.json = new JSONObject(rest
                .getBody(this.BASE_URL + SEARCH_FEATURE + keyword + "&limit=" + this.valuesPerPage + "&skip="
                        + this.skip));

        return json.getJSONArray("products");
    }


    /**
     * Helper method, used in pagination
     * {@link #nextPage()}
     * {@link #returnPage()}
     * {@link #selectPage(int pageSelection, int valuesPerPage)}
     * {@link #selectPage(int pageSelection)}
     */
    private JSONArray makeProductsJSONArray() {
        this.json = new JSONObject(
                rest.getBody(this.BASE_URL + "?skip=" + this.skip + "&limit=" + this.valuesPerPage));
        return json.getJSONArray("products");
    }
}
