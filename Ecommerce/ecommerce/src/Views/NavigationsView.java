package Views;

import java.util.ArrayList;
import java.util.Scanner;

import Controllers.NavigationsController;
import Controllers.ProductsController;
import Models.Product;

public class NavigationsView {
    public static Boolean inDetails = false;
    public static Boolean inSearch = false;
    public static void paginate(){
        Scanner in = new Scanner(System.in);
        String searchQueryTemp = "";
        if (!inSearch) ProductView.display(ProductsController.getProducts(1));
        // System.out.println("Limit:" + NavigationsController.limit);
        // System.out.println("Skip:" + NavigationsController.skip);

        if(NavigationsController.skip != 0) System.out.println("Back (0)");
        if(NavigationsController.limit + NavigationsController.skip != 100) System.out.println("Next (1)");
        if(!inDetails) System.out.println("Choose a product (2)");
        if(!inDetails && !inSearch) System.out.println("Search for a product (3)");
        
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
            ProductView.display(ProductsController.getProducts("https://dummyjson.com/products/" + userDecision));
            System.out.println("press any number to go back");
            userDecision = in.nextInt();
            inDetails = false;
            inSearch = false;
            paginate();
        }
        else if (userDecision == 3) {
            inSearch = true;
            System.out.println("Put your search query here: ");

            String searchQuery = in.next();
            ArrayList<Product> searchResult = ProductsController.getProducts(searchQuery);
            if(searchResult.size() != 0){
                ProductView.display(searchResult);

                userDecision = 2;
                paginate();
            }
            
            System.out.println("We don't have anything that matchs: " + searchQuery + ", Try again:");
            // inSearch = false;
            paginate();
        }                


        
    }
    
    // public static void read(int ){
        
        // }
    }
