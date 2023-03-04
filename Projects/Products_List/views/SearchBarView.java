package Projects.Products_List.views;

import java.util.ArrayList;
import java.util.Scanner;

import Projects.Products_List.controllers.ProductController;
import Projects.Products_List.models.Product;

public class SearchBarView {

    private ArrayList<Product> products;
    private ProductController productController;

    // REVIEW THIS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // page to look for
    
    public void searchBar() {

        Scanner userInput = new Scanner(System.in);
        System.out.println("-------------------------------------------------------");
        System.out.println("Search:");
        System.out.println("\n");
        System.out.print("Your search: ");
        
        String userChoice = userInput.nextLine();
        if (userChoice.equals("")) System.out.println("Invalid search.");

        productController = new ProductController();
        products = productController.getSearch(1, userChoice);

        /* if(products.) */
        
        for (int i = 0; i < products.size(); i++) {
            
            System.out.println("ID: " + products.get(i).getId());
            System.out.println("Title: " + products.get(i).getTitle());
            System.out.println("Description: " + products.get(i).getDescription());
            System.out.println("Price: " + products.get(i).getPrice());
            System.out.println("Discount Percentage: " + products.get(i).getDiscountPercentage());
            System.out.println("Rating: " + products.get(i).getRating());
            System.out.println("Stock: " + products.get(i).getStock());
            System.out.println("Brand: " + products.get(i).getBrand());
            System.out.println("Category: " + products.get(i).getCategory());
            System.out.println("Thumbnail: " + products.get(i).getThumbnail());
            System.out.println("Images:");
            for (int j = 0; j < products.get(i).getImages().size(); j++) {
                System.out.println(products.get(i).getImages().get(j));
            }
            System.out.println("\n");
            System.out.println("-------------------------------------------------------");
        }
    }
}
