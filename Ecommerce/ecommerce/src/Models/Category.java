package Models;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Category {
    private String category;

    public Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public static ArrayList<Category> listOutCategories(JSONArray categoriesArr) {
        ArrayList<Category> categories = new ArrayList<>();
        for (int i = 0; i < categoriesArr.length(); i++) {
            categories.add(new Category(categoriesArr.getString(i)));
        }
        return categories;
    }

}
