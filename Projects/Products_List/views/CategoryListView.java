package Projects.Products_List.views;

import java.util.ArrayList;

import Projects.Products_List.controllers.CategoryController;
import Projects.Products_List.models.Category;

public class CategoryListView {
    
    private ArrayList<Category> categories;
    private CategoryController categoryController;

    public void showList() {

        categories = categoryController.getAll(0);

        // like product list view
    }
}
