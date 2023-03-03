package Views;

import java.util.ArrayList;

import Models.Category;

public class CategoriesView {
    public static void display(ArrayList<Category> categories) {
        int categoryIndex = 1;
        for(Category category : categories) {
            // System.out.println("※------------------------~~ CATEGORIES ~~------------------------+※\n");
            System.out.println(categoryIndex + "  -->  " + category.getCategory());
            categoryIndex++;
        }
            
    }
}
