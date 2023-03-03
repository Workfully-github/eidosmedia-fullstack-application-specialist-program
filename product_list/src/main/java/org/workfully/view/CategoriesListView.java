package org.workfully.view;

import org.workfully.controllers.CategoryController;
import org.workfully.models.Category;

import java.util.ArrayList;

public class CategoriesListView extends BaseView {

    // Model
    private ArrayList<Category> categories;

    //Controller
    private CategoryController controller = new CategoryController();


    @Override
    public void display() {
        super.display();
        categories = controller.getAll();
        //use frontend-logic to show your model values.

    }
}
