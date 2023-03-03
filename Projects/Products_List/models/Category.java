package Projects.Products_List.models;

import java.util.ArrayList;

import org.json.JSONArray;

public class Category {

    private String name;
    //private JSONArray array;
    
    public static final String ENDPOINT = "/product/categories";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* public Category(JSONArray array) {
        this.array = array;
        categories = getAllCaregories(array);
    }

    private ArrayList<String> getAllCaregories(JSONArray jsonArray) {

        ArrayList<String> allCategories = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            allCategories.add(jsonArray.getString(i));
        }
        
        return allCategories;
    }

    public ArrayList<String> getCategories() {
        return categories;
    } */
}
