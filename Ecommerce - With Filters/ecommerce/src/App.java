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

    static ArrayList <Product> products = ProductView.getProducts();
    public static void main(String[] args) throws Exception {
        // NavigationsView.paginate();

        

        // ArrayList<Product> results = ProductsController.getProduct(99);
        // ProductView.display(results);

        // ArrayList<Product> results = ProductsController.getProducts("laptop");
        // ProductView.display(results);


        // ArrayList<Product> results = ProductsController.getProductsByCategory("laptops");
        // ProductView.display(results);


        // ArrayList<Category> results = CategoriesController.getProductCategories();
        // CategoriesView.display(results);

        
        ApiController rest = new ApiController();
        ProductView.setProducts(rest.call("https://dummyjson.com/products?skip=0&limit=100"));
        // NavigationsView.takeOff();
        System.out.println("[0] page1\n[1] page 2");
        test();
        
        
        // System.out.print("skip :: " + NavigationsController.getSkip() + "Limit :: " + NavigationsController.getLimit());
        
        
        // ArrayList<Product> results = ProductsController.getProductsByCategory("groceries");
        // ProductView.display(results);
        
        // Product results = ProductsController.getProduct(5);
        // ProductView.display(results);
        
    }
    public static void test(){
        Scanner in = new Scanner(System.in);
        int userIn = in.nextInt();
        ArrayList<Product> tempProducts = new ArrayList<>();
        if(userIn == 0) {
            for(int i = 0; i < 30; i++){
                tempProducts.add(products.get(i));
            }
            ProductView.display(tempProducts);
            test();
        }else if(userIn == 1) {
            for(int i = 30; i < 30; i++){
                tempProducts.add(products.get(i));
            }
            ProductView.display(tempProducts);
            test();
        }
    }
}
