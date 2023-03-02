package Views;

import java.util.Scanner;

import Controllers.NavigationsController;
import Controllers.ProductsController;

public class NavigationsView {
    public static Boolean inDetails = false;
    public static void paginate(){
        ProductView.display(ProductsController.getProducts("https://dummyjson.com/products", NavigationsController.skip, NavigationsController.limit));
        // System.out.println("Limit:" + NavigationsController.limit);
        // System.out.println("Skip:" + NavigationsController.skip);

        Scanner in = new Scanner(System.in);
        if(NavigationsController.skip != 0) System.out.println("Back (0)");
        if(NavigationsController.limit + NavigationsController.skip != 100) System.out.println("Next (1)");
        if(!inDetails) System.out.println("Choose a product (2)");
        
        int userDecision = in.nextInt();
        
        if(userDecision == 0){
            if(inDetails) return;
            NavigationsController.back();
            paginate();
        }else if(userDecision == 1){
            if(inDetails) return;
            NavigationsController.next();
            paginate();
        }else if (userDecision == 2) {
            inDetails = true;
            System.out.println("please inter product ID: (integer)");
            userDecision = in.nextInt();
            // ProductView.display(ProductsController.getProducts("https://dummyjson.com/products", NavigationsController.skip + userDecision - 1, 1));
            ProductView.display(ProductsController.getProduct("https://dummyjson.com/products/" + userDecision));
            System.out.println("press any number to go back");
            userDecision = in.nextInt();
            inDetails = false;
            paginate();
        }
        
    }
    
    // public static void read(int ){
        
        // }
    }
