package org.workfully.controllers;

import java.util.Locale.Category;

import org.json.JSONArray;
import org.json.JSONObject;
import org.workfully.models.Product;
import org.workfully.utilities.RestController;

/**
 * Paginator methods can all become static
 * they don't depend on external instances
 */
public class Paginator {

    private final String BASE_URL = "https://dummyjson.com/products";
    private final String CATEGORIES_RESOURCE = "/categories";
    private final String CATEGORY_FEATURE = "/category";
    private JSONObject json;
    private int pageSelection;
    private int pageNumber;
    private int skip;
    private int valuesPerPage;

    public JSONArray selectPage(int pageSelection, int valuesPerPage) {
        this.pageSelection = pageSelection;
        this.pageNumber = pageSelection - 1;
        this.valuesPerPage = valuesPerPage;
        this.skip = pageNumber * valuesPerPage;
        return makeProductsJSONArray();
    }

    public JSONArray selectPage(int pageSelection) {
        this.pageSelection = pageSelection;
        this.pageNumber = this.pageSelection - 1;
        int valuesPerPage = 30;
        this.skip = pageNumber * valuesPerPage;
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
        this.pageNumber++;
        this.pageSelection = this.pageNumber + 1;
        this.skip = this.pageNumber * this.valuesPerPage;
        return makeProductsJSONArray();
    }

    public int getPageSelection() {
        return this.pageSelection;
    }

    public JSONArray returnPage() {
        this.pageNumber--;
        this.pageSelection = this.pageNumber + 1;
        this.skip = this.pageNumber * this.valuesPerPage;
        return makeProductsJSONArray();
    }

    public Product getProduct(int id) {
        return new Product(new JSONObject(
                RestController
                        .getBody(BASE_URL + "/" + id)));
    }

    public JSONArray getCategoryList() {
        return new JSONArray(RestController
                .getBody(this.BASE_URL + CATEGORIES_RESOURCE));
    }

    public JSONArray getProductsByCategory(String category) {
        this.json = new JSONObject(RestController
                .getBody(this.BASE_URL + CATEGORY_FEATURE + "/" + category));

        return json.getJSONArray("products");
    }

    /**
     * @param keyword for searching products by keyword
     *                query not encapsulated since it has unique structure
     */
    public JSONArray getProductsByKeyword(String keyword) {
        this.json = new JSONObject(RestController
                .getBody(this.BASE_URL + "/" + "search?q=" + keyword + "&limit=" + this.valuesPerPage + "&skip="
                        + this.skip));

        return json.getJSONArray("products");
    }

    public JSONArray makeProductsJSONArray() {
        this.json = new JSONObject(
                RestController.getBody(this.BASE_URL + "?skip=" + this.skip + "&limit=" + this.valuesPerPage));
        return json.getJSONArray("products");
    }
}
