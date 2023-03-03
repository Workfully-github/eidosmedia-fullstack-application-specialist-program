package Controllers;

import java.util.ArrayList;

import org.json.JSONArray;

import Models.Category;

public class CategoriesController {
    private static String url = "";
     private static JSONArray data = new JSONArray();
     
    public static ArrayList <Category> getProductCategories() { 
        ApiController apiController = new ApiController();
            url = apiController.getUrl(Constants.BASE_URL, Constants.CATEGORIES_ROUT); 
            data = apiController.callCategories(url);
            return Category.listOutCategories(data);
   }
}
