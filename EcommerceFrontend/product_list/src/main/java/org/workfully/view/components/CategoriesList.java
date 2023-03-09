package org.workfully.view.components;

import org.workfully.controllers.CategoryController;
import org.workfully.models.Category;
import org.workfully.utilities.StringPrinter;
import org.workfully.view.interfaces.Displays;

public class CategoriesList implements Displays {

    private CategoryController categoryController;

    public CategoriesList() {
        this.categoryController = new CategoryController();
    }

    @Override
    public void display() {
        int counter = 0;

        for (Category category : categoryController.getAll()) {
            counter++;
            StringPrinter.println("[" + counter + "] -> " + category.getName());
        }
    }

    public String getCategoryName(int id) {
        return categoryController.getOne(id).getName();
    }

    public Category getCategory(int id) {
        return categoryController.getOne(id);
    }
}