package Controllers;

import java.util.ArrayList;

import org.json.JSONArray;

import Models.Product;
public class ProductsController {
    public void display(){
    }

   public static ArrayList<Product> getProducts(String url, int skip, int limit) {
        ApiController apiController = new ApiController();
        return Product.listOut(apiController.call(url, skip, limit));
   }


}
