package Views;

import java.util.ArrayList;
import java.util.Scanner;

import Controllers.NavigationsController;
import Controllers.ProductsController;
import Models.Product;

public class NavigationsView {
    public static Boolean inDetails = false;
    public static Boolean inSearch = false;
    
    public static void takeOff() {
        System.out.println("WELCOME TO THE STORE");
        Scanner in = new Scanner(System.in);
        System.out.println("[0] --> Browse Products\n[1] --> Browse Products by Categories\n[2] --> Search Products\n");
        int userDecision = in.nextInt();
        switch (userDecision) {
            case 0:
                ProductView.navigate();
                break;
            
            case 1 :
                CategoriesView.navigate();

                break;

            case 2 :
            ProductView.search();
                break;

            default:
                break;
        }
    }
    

    }
