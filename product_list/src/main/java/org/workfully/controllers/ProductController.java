package org.workfully.controllers;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.workfully.models.Product;

public class ProductController {

    /**
     * @param products refers to an array of products from api
     *                 {@link https://dummyjson.com/products}
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

}
