package org.workfully.view.components;

import org.workfully.controllers.CategoryController;
import org.workfully.models.Category;
import org.workfully.view.BasicView;

public class CategoryDetail extends BasicView{

    private CategoryController categoryController;
    private Category category;


    public CategoryDetail(int id) {
        this.categoryController = new CategoryController();
        this.category = categoryController.getOne(id);
    }

    @Override
    public void display() {
       
    }
}
