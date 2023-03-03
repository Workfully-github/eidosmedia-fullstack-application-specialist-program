package org.workfully.controllers;

import java.util.ArrayList;

import org.json.JSONArray;
import org.workfully.http.APIController;
import org.workfully.http.RestController;
import org.workfully.models.Category;

public class CategoryController {
    private final String BASE_URL = "https://dummyjson.com/products";
    private final String CATEGORIES_RESOURCE = "/categories";
    
    private APIController apiController;


    public ArrayList<Category> getAll(){


        JSONArray data = apiController.getCategoryList("adsads");
        //HOW TO get the categories?



        return categories;

    }

    public Category getOne(int id){
        Category category;

        //HOW TO get the category?

        return category;

    }





}
