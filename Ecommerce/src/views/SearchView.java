package views;

import controllers.ProductController;
import models.Product;

import java.util.ArrayList;

public class SearchView {

    private ProductController controller = new ProductController();
    private ArrayList<Product> products;


    public void showSearchResult(){
        String searchQuery = "Laptop";
        products = controller.search(searchQuery,1);
    }
}
