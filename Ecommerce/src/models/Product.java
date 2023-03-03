package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Product {


    public static final String ENDPOINT = "/products";
    public static final String KEY_PRODUCTS = "products";

    //attributes

    public Product(JSONObject json){
        //data binding

    }

    public static ArrayList<Product> getList(JSONArray json){
        ArrayList<Product> products = new ArrayList<>();

        for (int i= 0; i< json.length(); i++){
            products.add(new Product(json.getJSONObject(i)));

        }
        return products;
    }
}
