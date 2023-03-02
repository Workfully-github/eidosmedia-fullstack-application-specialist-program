package org.workfully.controllers;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.workfully.models.Product;

public class ProductController {

    private Paginator paginator;
    private ArrayList<Product> productList;

    public ProductController() {
    }

    public ProductController(int valuesPerPage, int pageSelection) {
        this.paginator = new Paginator();
        this.productList = generateProductList(this.paginator.selectPage(pageSelection, valuesPerPage));
    }

    public ArrayList<Product> generateProductList(JSONArray products) {

        ArrayList<Product> productArray = new ArrayList<>();

        for (Object product : products) {
            //System.out.println(product);
            productArray.add(new Product(((JSONObject) product)));
        }

        return productArray;
    }

    public Paginator getPaginator() {
        return paginator;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    
    
}
