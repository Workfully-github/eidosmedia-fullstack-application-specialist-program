package Controllers;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import Models.Product;
public class ProductsController {

    

     
     
     
     
     private static String url = "";
     private static JSONArray data = new JSONArray();
     private static JSONObject dataObj = new JSONObject();
     
     public static ArrayList<Product> getProducts(int page) { 
          ApiController apiController = new ApiController();
          String pageQueries = NavigationsController.pagetranslator(page);
          url = apiController.getUrl(Constants.BASE_URL, pageQueries); 
          data = apiController.call(url);
          return Product.listOut(data);
     }

     public static ArrayList<Product> getProducts(String searchQuery) { 
          ApiController apiController = new ApiController();
          url = apiController.getUrl(Constants.BASE_URL, Constants.SEARCH_ROUT, Constants.SEARCH_QUERY_STRING, searchQuery); 
          data = apiController.call(url);
          return Product.listOut(data);
     }

     public static ArrayList<Product> getProductsByCategory(String category) { 
          ApiController apiController = new ApiController();
          url = apiController.getUrl(Constants.BASE_URL, Constants.CATEGORY_ROUT, category); 
          data = apiController.call(url);
          return Product.listOut(data);
     }

     public static ArrayList<Product> getProduct(int productID) { 
          ApiController apiController = new ApiController();
          url = apiController.getUrl(Constants.BASE_URL, Integer.toString(productID));
          dataObj =  apiController.callProduct(url);
          return Product.listOut(dataObj);
     }

}
