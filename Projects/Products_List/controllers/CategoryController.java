package Projects.Products_List.controllers;

import java.util.ArrayList;

import org.json.JSONArray;

import Projects.Products_List.models.Category;
import Projects.Products_List.models.Product;

// ASK AMINE IF IS RIGHT TO USE PRODUCT METHOR TO CREATE LIST OF PRODUCTS

public class CategoryController {
    
    JsonController jsonController = new JsonController();

    public ArrayList<Category> getAll(int page) {

        ArrayList<Category> categories = new ArrayList<>();

        String responseBody = jsonController.get(Category.ENDPOINT, page);

        if(null != responseBody) {
            JSONArray response = new JSONArray(responseBody);
            return new ArrayList<Category>();
        }
        return new ArrayList<Category>();
    }

    public Category getOneCategory(int id) {

        Category category = new Category();

        // how to get one

        return category;
    }

    /* public ArrayList<Product> getAll(int page) {

        String responseBody = jsonController.get(Category.ENDPOINT, page);

        if(null != responseBody) {
            JSONArray response = new JSONArray(responseBody);
            return Product.createListProducts(response);
        }
        return new ArrayList<Product>();
    } */
}
