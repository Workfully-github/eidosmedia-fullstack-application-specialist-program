package controllers;

import http.RestController;
import models.Product;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductController {

    private RestController rest = new RestController();


    public ArrayList<Product> getAll(int page){

        String response = rest.get(Product.ENDPOINT,page);



        if(null != response){
            JSONObject responseJSON = new JSONObject(response);
            return Product.getList(responseJSON.getJSONArray(Product.KEY_PRODUCTS));
        }

        return new ArrayList<Product>();


    }

    public ArrayList<Product> search(String query, int page){
        String response = rest.get(Product.ENDPOINT,page, "/search?q=" + query);

        if(null != response){
            JSONObject responseJSON = new JSONObject(response);
            return Product.getList(responseJSON.getJSONArray(Product.KEY_PRODUCTS));
        }

        return new ArrayList<Product>();
    }







}
