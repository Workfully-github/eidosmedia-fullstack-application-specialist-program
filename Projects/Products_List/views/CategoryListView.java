package Projects.Products_List.views;

import java.util.ArrayList;

import Projects.Products_List.controllers.CategoryController;
import Projects.Products_List.models.Product;

public class CategoryListView {

    private ArrayList<Product> products;

    public void showList(String category) {

        CategoryController categoryController = new CategoryController();
        products = categoryController.getAll(category);

        displayList(products);

        ListingDialog listingDialog = new ListingDialog();
        listingDialog.initiateDialog();
    }
    
    public void displayList(ArrayList<Product> products) {

        System.out.println("-------------------------------------------------------");
        System.out.println("LIST OF PRODUCTS AVAILABLE:");
        System.out.println("\n");
        
        for (int i = 0; i < products.size(); i++) {

            System.out.println("______________________________________________________________________");
            System.out.println("|                                                                     |");
            System.out.printf("%10.70s|%n", "|  ID: " + products.get(i).getId() + "                                                              ");
            System.out.printf("%10.70s|%n", "|                      Title: " + products.get(i).getTitle() + "                                                              ");
            System.out.println("|                                                                     |");
            System.out.printf("%10.70s|%n", "|      Price: " + products.get(i).getPrice() + "$" + "   Discount: " + products.get(i).getDiscountPercentage()
            + "%  " + "   Rating: " + products.get(i).getRating() + "   Stock: " + products.get(i).getStock() + "      |");
            System.out.println("|                                                                     |");
            System.out.printf("%10.60s...       |%n", "|      " + products.get(i).getDescription());
            System.out.println("|                                                                     |");
            System.out.println("______________________________________________________________________");
            
            /* System.out.println("ID: " + products.get(i).getId());
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
                System.out.println("  --> " + products.get(i).getImages().get(j));
            }
            System.out.println("\n");
            System.out.println("-------------------------------------------------------"); */
        }
    }
}
