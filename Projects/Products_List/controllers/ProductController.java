package Projects.Products_List.controllers;

import java.util.ArrayList;

import org.json.JSONObject;

import Projects.Products_List.models.Product;

public class ProductController {
    
    public static ArrayList<Product> getAll(int page) {

        String responseBody = JsonController.get(Product.ENDPOINT, page);

        if(null != responseBody){
            JSONObject response = new JSONObject(responseBody);
            return Product.createListProducts(response.getJSONArray(Product.KEY_PRODUCTS));
        }
        return new ArrayList<Product>();
    }

    public ArrayList<Product> getSearch(String query) {

        String responseBody = JsonController.get(Product.ENDPOINT, 0, "/search?q=" + query);

        if(null != responseBody){
            JSONObject response = new JSONObject(responseBody);
            return Product.createListProducts(response.getJSONArray(Product.KEY_PRODUCTS));
        }
        return new ArrayList<Product>();
    }

    public Product getSingleProduct(int id){

        String responseBody = JsonController.get(Product.ENDPOINT + "/" + id, 0);
        
        if(null != responseBody) {
            JSONObject response = new JSONObject(responseBody);
            return Product.createSingleProduct(response);
        }
        return new Product(null);
    }
}
