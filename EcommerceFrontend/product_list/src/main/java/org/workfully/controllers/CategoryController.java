package org.workfully.controllers;

import java.util.ArrayList;

import org.workfully.http.APIController;
import org.workfully.models.Category;

public class CategoryController {

    private APIController apiController;

    public CategoryController() {
        this.apiController = new APIController();
    }

    public ArrayList<Category> getAll() {
        return new ArrayList<Category>() {
            {
                for (Object category : apiController.getCategoryList()) {
                    add(new Category(category.toString()));
                }
            }
        };
    }

    public Category getOne(int id) {
        return new Category(apiController.getCategoryList().getString(id));
    }
}
