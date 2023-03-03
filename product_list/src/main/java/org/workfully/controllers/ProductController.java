package org.workfully.controllers;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.workfully.http.APIController;
import org.workfully.models.Product;

public class ProductController {

    private APIController apiController;
    private ArrayList<Product> dynamicProductList;
    private ArrayList<Product> allProductsList;

    public ProductController() {}

    public ProductController(int valuesPerPage, int pageSelection) {
        this.apiController = new APIController();
        this.allProductsList = generateProductList(this.apiController.selectPage(pageSelection, valuesPerPage));
        this.dynamicProductList = generateProductList(this.apiController.selectPage(pageSelection, valuesPerPage));
    }

    /**
     * @param products refers to an array of products from api {@link https://dummyjson.com/products}
     * @return ArrayList<Product> from @param products
     */
    public ArrayList<Product> generateProductList(JSONArray products) {
        return new ArrayList<Product>() {
            {
                for (Object product : products) {
                    add(new Product(((JSONObject) product)));
                }
            }
        };
    }

    public APIController getPaginator() {
        return apiController;
    }

    public ArrayList<Product> getProductList() {
        return dynamicProductList;
    }

    public ArrayList<Product> getDynamicProductList() {
        return dynamicProductList;
    }

    public ArrayList<Product> getAllProductsList() {
        return allProductsList;
    }

    
}
