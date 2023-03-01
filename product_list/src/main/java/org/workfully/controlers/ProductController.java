package org.workfully.controlers;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.workfully.models.Product;

public class ProductController {

    public ArrayList<Product> generateProductList(JSONArray products) {

        ArrayList<Product> productArray = new ArrayList<>();

        for (Object product : products) {
            //System.out.println(product);
            productArray.add(new Product(((JSONObject) product)));
        }

        return productArray;

    }
    
}
