package Projects.Products_List.views;

import java.util.ArrayList;
import java.util.Scanner;

import Projects.Products_List.controllers.ProductController;
import Projects.Products_List.models.Product;

public class SearchBarView {

    private ArrayList<Product> products;
    private ProductController productController;
    
    public void searchBar() {

        Scanner userInput = new Scanner(System.in);
        System.out.println("-------------------------------------------------------");
        System.out.println("Search:");
        System.out.println("\n");
        System.out.print("Your search: ");
        
        String userChoice = userInput.nextLine();
        if (userChoice.equals("")) System.out.println("Invalid search.");

        productController = new ProductController();
        products = productController.getSearch(userChoice);

        ProductListView productList = new ProductListView();
        productList.displayList(products);
    }
}
