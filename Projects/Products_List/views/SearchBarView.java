package Projects.Products_List.views;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import Projects.Products_List.controllers.ProductController;
import Projects.Products_List.models.Product;

public class SearchBarView {

    private ArrayList<Product> products;
    private ProductController productController;
    
    public void searchBar(int skip, int limit) throws IOException, ParseException {

        
        Scanner userInput = new Scanner(System.in);
        System.out.println("-------------------------------------------------------");
        System.out.println("Search:");
        System.out.println("\n");
        System.out.print("Your search: ");
        
        String userChoice = userInput.nextLine();
        if (userChoice.equals("")) System.out.println("Invalida search.");

        productController = new ProductController();
        products = productController.getAllSearch(skip, limit, userChoice);

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
