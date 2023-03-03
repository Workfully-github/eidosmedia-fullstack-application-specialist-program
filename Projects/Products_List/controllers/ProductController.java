package Projects.Products_List.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import Projects.Products_List.models.Product;

public class ProductController {
    
    private JsonController jsonController = new JsonController();
    
    public ArrayList<Product> getAll(int page) {

        String responseBody = jsonController.get(Product.ENDPOINT, page);

        if(null != responseBody){
            JSONObject response = new JSONObject(responseBody);
            return Product.createListProducts(response.getJSONArray(Product.KEY_PRODUCTS));
        }
        return new ArrayList<Product>();
    }

    public ArrayList<Product> getSearch(int page, String query) {

        String responseBody = jsonController.get(Product.ENDPOINT, page, query);
        
        if(null == responseBody){
            JSONObject response = new JSONObject(responseBody);
            return Product.createListProducts(response.getJSONArray(Product.KEY_PRODUCTS));
        }
        return new ArrayList<Product>();
    }

    public Product getSingleProduct(int id, int page) throws IOException, ParseException {

        String responseBody = jsonController.get(Product.ENDPOINT + id, page);
        
        if(null != responseBody) {
            JSONObject response = new JSONObject(responseBody);
            JSONArray responseArray = response.getJSONArray(Product.KEY_PRODUCTS);
            JSONObject object = new JSONObject();
            
            for (int i = 0; i < responseArray.length(); i++) {
                if (responseArray.getJSONObject(i).getInt("id") == id) object = responseArray.getJSONObject(i);
            }
            return Product.createSingleProduct(object);
        }


        return new Product(null);
    }


    // DELETE


    /* public Product getSingleProduct(int id) throws IOException, ParseException {

        JSONArray response = jsonController.getJson(0, 100);
        JSONObject object = new JSONObject(); 

        for (int i = 0; i < response.length(); i++) {
            if (response.getJSONObject(i).getInt("id") == id) object = response.getJSONObject(i);
        }

        return Product.createSingleProduct(object);
    }

    public ArrayList<Product> getAllSearch(int skip, int limit, String query) throws IOException, ParseException {

        JSONArray response = jsonController.getQueryJson(skip, limit, query);

        return Product.createListProducts(response);
    } */
}
