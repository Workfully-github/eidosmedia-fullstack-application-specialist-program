package Projects.Products_List.models;

import java.util.ArrayList;

import org.json.JSONArray;

public class Category {

    private String name;
    
    public static final String ENDPOINT = "/product/category/";
    public static final String ENDPOINT_LIST = "/product/categories";
    public static final String KEY_PRODUCTS = "products";

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ArrayList<Category> createListCategories(JSONArray array) {
        
        ArrayList<Category> categoriesArray = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            categoriesArray.add(new Category(array.getString(i)));
        }
        return categoriesArray;
    }
}
