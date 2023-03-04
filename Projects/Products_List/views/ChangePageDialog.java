package Projects.Products_List.views;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import Projects.Products_List.MainProducts;
import Projects.Products_List.controllers.JsonController;
import Projects.Products_List.controllers.ProductController;

public class ChangePageDialog {
    
    private static final int BACK = 1;
    private static final int MORE = 2;

    public void choosePage(int skip) throws IOException, ParseException {

        Scanner userInput = new Scanner(System.in);
        System.out.println("-------------------------------------------------------");
        System.out.println("\n");
        System.out.println("Do you wish to see more products or go back?");
        System.out.println("[1] --> Go Back");
        System.out.println("[2] --> See more products");
        System.out.println("\n");
        System.out.print("Let's go to: ");

        int userChoice = userInput.nextInt();

        switch (userChoice) {
            case BACK:
                if (skip - 20 <= 0) {
                    System.out.println("\n");
                    System.out.println("You're at the beginning. It's not possible to go back.");
                    System.out.println("\n");
                    break;
                } else {
                    MainProducts.initialize();
                    break;
                }
            case MORE:
                if (skip + 20 > 100) {
                    System.out.println("\n");
                    System.out.println("You reached the end. No more products to see.");
                    System.out.println("\n");
                    break;
                } else {
                    MainProducts.initialize();
                    break;
                }
        }
    }
}
