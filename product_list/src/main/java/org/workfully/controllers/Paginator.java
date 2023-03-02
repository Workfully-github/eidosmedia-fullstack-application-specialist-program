package org.workfully.controllers;

import org.json.JSONArray;
import org.json.JSONObject;
import org.workfully.utilities.RestController;

public class Paginator {

    private JSONObject json;
    private int pageSelection;
    private int pageNumber;
    private int skip;
    private int valuesPerPage;

    public JSONArray selectPage(int pageSelection, int valuesPerPage) {
        this.pageSelection = pageSelection;
        this.valuesPerPage = valuesPerPage;
        this.pageNumber = pageSelection - 1;
        this.skip = pageNumber * valuesPerPage;
        this.json = new JSONObject(
                RestController.getBody("https://dummyjson.com/products?skip=" + skip + "&limit=" + valuesPerPage));
        return json.getJSONArray("products");
    }

    public JSONArray selectPage(int pageSelection) {
        this.pageSelection = pageSelection;
        this.pageNumber = this.pageSelection - 1;
        int valuesPerPage = 30;
        this.skip = pageNumber * valuesPerPage;
        this.json = new JSONObject(
                RestController
                        .getBody("https://dummyjson.com/products?skip=" + this.skip + "&limit=" + this.valuesPerPage));
        return json.getJSONArray("products");
    }

    public int getTotalPages() {
        return this.json.getInt("total");
    }

    public int getPagesLeft() {
        int limit = this.json.getInt("limit");
        return getTotalPages() / limit - this.pageSelection;
    }

    public JSONArray nextPage() {
        this.pageNumber++;
        this.pageSelection = this.pageNumber + 1;
        this.skip = this.pageNumber * this.valuesPerPage;
        this.json = new JSONObject(
                RestController
                        .getBody("https://dummyjson.com/products?skip=" + this.skip + "&limit=" + this.valuesPerPage));
        return json.getJSONArray("products");
    }

    public int getPageSelection() {
        return pageSelection;
    }

    public JSONArray returnPage() {
        this.pageNumber--;
        this.pageSelection = this.pageNumber + 1;
        this.skip = this.pageNumber * this.valuesPerPage;
        this.json = new JSONObject(
                RestController
                        .getBody("https://dummyjson.com/products?skip=" + this.skip + "&limit=" + this.valuesPerPage));
        return json.getJSONArray("products");
    }
}
