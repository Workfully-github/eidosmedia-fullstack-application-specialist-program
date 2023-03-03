package org.workfully.view;

import org.workfully.controllers.CategoryController;
import org.workfully.models.Category;

public class CategoryDetail extends BasicView{

    private CategoryController categoryController;
    private Category category;


    public CategoryDetail(int id) {
        this.categoryController = new CategoryController();
        this.category = categoryController.getOne(id);
    }

    @Override
    public void display() {
        super.display();
    }
}
