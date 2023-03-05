package Projects.Products_List.views;

import java.util.ArrayList;

import Projects.Products_List.controllers.PageController;
import Projects.Products_List.controllers.ProductController;
import Projects.Products_List.models.Product;

public class ProductListView {

    private ArrayList<Product> products;

    public void showList() {

        products = ProductController.getAll(PageController.getPageNumber());

        displayList(products);

        ListingDialog listingDialog = new ListingDialog();
        listingDialog.initiateDialog();
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
                System.out.println("  --> " + products.get(i).getImages().get(j));
            }
            System.out.println("\n");
            System.out.println("-------------------------------------------------------");
        }
    }
}
