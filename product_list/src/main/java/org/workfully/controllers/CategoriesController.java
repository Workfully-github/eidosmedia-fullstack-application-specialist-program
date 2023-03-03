package org.workfully.controllers;

import java.util.ArrayList;

import org.json.JSONArray;
import org.workfully.models.Category;
import org.workfully.utilities.RestController;

public class CategoriesController {

    private Category categories;
    
    private final String BASE_URL = "https://dummyjson.com/products";
    private final String CATEGORIES_RESOURCE = "/categories";
    

    

    public CategoriesController() {
        this.categories = new Category();
        this.categories.setCategoriesList(generateCategoryList(getCategoryListFromAPI()));
    }

    private ArrayList<String> generateCategoryList(JSONArray categories) {
        return new ArrayList<String>() {
            {
                for (Object category : categories) {
                    add(((String) category));
                }
            }
        };
    }

    private JSONArray getCategoryListFromAPI() {
        return new JSONArray(RestController
                .getBody(this.BASE_URL + CATEGORIES_RESOURCE));
    }

    public ArrayList<String> getCategoryListFromDB() {
        return categories.getCategoriesList();
    }
}
