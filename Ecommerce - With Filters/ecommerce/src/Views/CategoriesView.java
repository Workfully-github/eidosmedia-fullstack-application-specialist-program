package Views;

import java.util.ArrayList;
import java.util.Scanner;

import Controllers.CategoriesController;
import Controllers.NavigationsController;
import Controllers.ProductsController;
import Models.Category;

public class CategoriesView {
    
    private static ArrayList<Category> categories = new ArrayList<>();

    public static void navigate() {
        Scanner in = new Scanner(System.in);

        System.out.println("※------------------------~~ CATEGORIES ~~------------------------+※\n");
        categories = CategoriesController.getProductCategories();
        display(categories);
        

        System.out.println("[0] Choose a category");
        System.out.println("[1] Go back");

        int userDecision = in.nextInt();

        switch (userDecision) {
            case 0:
                System.out.println("Which category you want to see: (put category index)");
                userDecision = in.nextInt();
                ProductView.display(ProductsController.getProductsByCategory(categories.get(userDecision - 1).getCategory()));
                System.out.println("[0] --> Go back");
                userDecision = in.nextInt();
                navigate();
                break;

            case 1:
                    NavigationsView.takeOff();
                    break;
            default:
                break;
        }

        
    }

    public static void display(ArrayList<Category> categories) {
        int categoryIndex = 1;
        for(Category category : categories) {
            System.out.println(categoryIndex + "  -->  " + category.getCategory());
            categoryIndex++;
        }
            
    }
}
