package org.workfully.view.components;

import java.util.ArrayList;

import org.workfully.controllers.CategoryController;
import org.workfully.models.Category;
import org.workfully.utilities.StringPrinter;
import org.workfully.view.interfaces.Displays;

public class CategoriesList implements Displays {

    private CategoryController categoryController;
    private ArrayList<Category> categoryList;

    public CategoriesList() {
        this.categoryController = new CategoryController();
        this.categoryList = categoryController.getAll();
    }

    @Override
    public void display() {
        int counter = 0;

        for (Category category : categoryList) {
            counter++;
            StringPrinter.println("[" + counter + "] -> " + category.getName());
        }
    }

    public String getCategoryName(int id) {
        return categoryController.getOne(id).getName();
    }

    public Category getCategory(int id) {
        return categoryList.get(id);
    }
}