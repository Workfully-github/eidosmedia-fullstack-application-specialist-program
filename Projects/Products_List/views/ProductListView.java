package Projects.Products_List.views;

import java.util.ArrayList;
import java.util.Scanner;

import Projects.Products_List.controllers.PageController;
import Projects.Products_List.controllers.ProductController;
import Projects.Products_List.models.Product;

public class ProductListView {

    private ArrayList<Product> products;
    private ProductController productController;

    private static final int NEXT_PAGE = 1;
    private static final int PREVIOUS_PAGE = 2;
    private static final int DETAIL = 3; 
    private static final int HOME = 4;

    // REVIEW THIS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    public void showList() {

        products = ProductController.getAll(PageController.getPageNumber());

        displayList(products);

        ListingDialog listingDialog = new ListingDialog();
        listingDialog.initiateDialog();

        /* Scanner userInput = new Scanner(System.in);
        System.out.println("-------------------------------------------------------");
        System.out.println("What do you want to do next?");
        System.out.println("\n");
        // Validate if is the first page
        System.out.println("[1] --> Next Page");
        System.out.println("[2] --> Previous Page");
        System.out.println("[3] --> Product Detail");
        System.out.println("[4] --> Go Back Home");
        System.out.println("\n");
        System.out.print("Your answer: ");

        int userChoice = userInput.nextInt();
        
        switch (userChoice) {
            case NEXT_PAGE:
                PageController.nextPage();
                showList();
                break;
            case PREVIOUS_PAGE:
                PageController.previousPage();
                showList();
                break;
            case DETAIL:
                
                //showList();
                break;
            case HOME:
                StartingDialog home = new StartingDialog();
                home.initiateDialog();
                break;
        } */
    }
    
    public void displayList(ArrayList<Product> products) {

        System.out.println("-------------------------------------------------------");
        System.out.println("LIST OF PRODUCTS AVAILABLE:");
        System.out.println("\n");
        
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
