package Controllers;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import Models.Product;
public class ProductsController {

    

     
     
     
     
     private static JSONArray data = new JSONArray();
     private static JSONObject dataObj = new JSONObject();
     
     public static ArrayList<Product> getProductsByPage(int page) { 
          // NavigationsController.setCurrentPage(page);
          return Product.getProducts(page);
     }

     public static ArrayList<Product> getProducts(String searchQuery) { 
          ApiController apiController = new ApiController();
          data = apiController.fetchSearchedProducts(searchQuery);
          return Product.listOut(data);
     }

     public static ArrayList<Product> getProductsByCategory(String category) { 
          //loop through all product and return only the products of a certain category
          ArrayList<Product> categoryProducts = new ArrayList<>();
          for (Product product : Product.getProducts()) {
               if(product.getCategory().equals(category)) {
                    categoryProducts.add(product);
               }
          }

          return categoryProducts;
     }

     public static Product getProduct(int productID) { 
          return  Product.getProduct(productID - 1);
     }
     

}
