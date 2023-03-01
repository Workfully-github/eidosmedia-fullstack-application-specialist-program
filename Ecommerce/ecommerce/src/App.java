import java.util.Scanner;

import Controllers.ApiController;
import Controllers.NavigationsController;
import Controllers.ProductsController;
import Views.NavigationsView;
import Views.ProductView;

public class App {
    // ProductsController productsController = new ProductsController();
    public static void main(String[] args) throws Exception {
        // ProductsController.getProducts("https://dummyjson.com/products", 0, 30);
        ProductView.display(ProductsController.getProducts("https://dummyjson.com/products", NavigationsController.skip, NavigationsController.limit));
        NavigationsView.navigate();
        
        
    }
    
    
}
