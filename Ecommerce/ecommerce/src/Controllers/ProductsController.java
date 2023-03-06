package Controllers;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import Models.Product;

public class ProductsController {

     private static JSONArray data = new JSONArray();
     private static JSONObject dataObj = new JSONObject();

     public static ArrayList<Product> getProducts(int page) {
          ApiController apiController = new ApiController();
          data = apiController.fetchProducts(page);
          return Product.listOut(data);
     }

     public static ArrayList<Product> getProducts(String searchQuery) {
          ApiController apiController = new ApiController();
          data = apiController.fetchSearchedProducts(searchQuery);
          return Product.listOut(data);
     }

     public static ArrayList<Product> getProductsByCategory(String category) {
          ApiController apiController = new ApiController();
          data = apiController.fetchProductsByCategory(category);
          return Product.listOut(data);
     }

     public static Product getProduct(int productID) {
          ApiController apiController = new ApiController();
          dataObj = apiController.getProductById(productID);
          return Product.listOut(dataObj);
     }

}
