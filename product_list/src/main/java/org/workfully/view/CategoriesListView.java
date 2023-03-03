package org.workfully.view;

import org.workfully.controllers.CategoryController;
import org.workfully.models.Category;
import org.workfully.utilities.StringPrinter;

public class CategoriesListView extends BasicView {

    private CategoryController categoryController;

    public CategoriesListView() {
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

    public String getCategory(int id){
        return categoryController.getOne(id).getName();
    }
}