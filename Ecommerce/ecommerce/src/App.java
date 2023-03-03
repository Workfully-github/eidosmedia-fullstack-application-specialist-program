import java.util.ArrayList;
import java.util.Scanner;

import Controllers.ApiController;
import Controllers.CategoriesController;
import Controllers.NavigationsController;
import Controllers.ProductsController;
import Models.Category;
import Models.Product;
import Views.CategoriesView;
import Views.NavigationsView;
import Views.ProductView;

public class App {
    ProductsController productsController = new ProductsController();
    private static final String BASE_URL= "https://dummyjson.com/products/";

    public static void main(String[] args) throws Exception {
        // NavigationsView.paginate();

        // ArrayList<Product> results = ProductsController.getProducts(0);
        // ProductView.display(results);

        // ArrayList<Product> results = ProductsController.getProduct(99);
        // ProductView.display(results);

        // ArrayList<Product> results = ProductsController.getProducts("laptop");
        // ProductView.display(results);


        // ArrayList<Product> results = ProductsController.getProductsByCategory("laptops");
        // ProductView.display(results);


        // ArrayList<Category> results = CategoriesController.getProductCategories();
        // CategoriesView.display(results);

        NavigationsView.takeOff();

    }
}
