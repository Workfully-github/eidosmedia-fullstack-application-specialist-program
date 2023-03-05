package Projects.Products_List.views;

import java.util.ArrayList;
import java.util.Scanner;

import Projects.Products_List.controllers.CategoryController;
import Projects.Products_List.models.Category;
import Projects.Products_List.models.Product;

public class ChooseCategoryDialog {

    private ArrayList<Category> categories;
    private ArrayList<Product> products;
    private CategoryController categoryController;
    
    public void chooseCategory() {

        categoryController = new CategoryController();
        categories = categoryController.getCategories();

        Scanner userInput = new Scanner(System.in);
        System.out.println("-------------------------------------------------------");
        System.out.println("Select a category from the list bellow:");
        System.out.println("\n");

        for (int i = 0; i < categories.size(); i++) {
            System.out.println("-> " + categories.get(i).getName());
        }

        System.out.println("\n");
        System.out.print("Your category: ");
        
        String userChoice = userInput.nextLine();
        if (userChoice.equals("")) System.out.println("Invalid search.");

        products = categoryController.getAll(userChoice);

        CategoryListView productList = new CategoryListView();
        productList.displayList(products);
    }
}
