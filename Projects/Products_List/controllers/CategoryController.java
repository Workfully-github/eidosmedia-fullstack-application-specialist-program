package Projects.Products_List.controllers;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import Projects.Products_List.models.Category;
import Projects.Products_List.models.Product;

public class CategoryController {

    public ArrayList<Product> getAll(String category) {

        String responseBody = JsonController.get(Category.ENDPOINT, 0, category);

        if(null != responseBody){
            JSONObject response = new JSONObject(responseBody);
            return Product.createListProducts(response.getJSONArray(Category.KEY_PRODUCTS));
        }
        return new ArrayList<Product>();
    }

    public ArrayList<Category> getCategories() {

        String responseBody = JsonController.get(Category.ENDPOINT_LIST, 0);

        if(null != responseBody){
            JSONArray response = new JSONArray(responseBody);
            return Category.createListCategories(response);
        }
        return new ArrayList<Category>();
    }
}
