package Views;

import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;

import Controllers.NavigationsController;
import Controllers.ProductsController;
import Models.Product;

public class ProductView {
    private static ArrayList<Product> searchResults = new ArrayList<>();
    public static ArrayList<Product> products = new ArrayList<>();
    

    public static void setProducts(JSONArray productsJsonArr){
        for(int i = 0; i < productsJsonArr.length(); i++){
            products.add(new Product(productsJsonArr.getJSONObject(i)));
        }
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static Product getProduct(int id) {
        return products.get(id);
    }

    public static void navigate(){
        Scanner in = new Scanner(System.in);

        display(ProductsController.getProductsByPage(NavigationsController.currentPage));
        
        System.out.println("Navigate from here:\nCurrent Page [" + NavigationsController.currentPage + "]");

        if(NavigationsController.currentPage != 1) System.out.println("[0] --> BACK");
        System.out.println("[1] --> NEXT");
        System.out.println("[2] --> See a product details");
        System.out.println("[3] --> Go back");

        int userDecision = in.nextInt();

        switch (userDecision) {
            case 0:
                if(NavigationsController.currentPage == 1) return;
                    NavigationsController.back();
                    navigate();
                break;
            case 1:
                // if(NavigationsController.currentPage == 1) return;
                    NavigationsController.next();
                    navigate();
                break;
            
            case 2:
            // if(NavigationsController.currentPage == 1) return;
                navigateToProduct();
            break;


            case 3:
                NavigationsView.takeOff();
            break;
            default:
                break;
        }

    }

    public static void search() {
        Scanner in = new Scanner(System.in);
        System.out.print("Type your search keyword here: ");
        String userSearchInput = in.nextLine();
        searchResults = ProductsController.getProducts(userSearchInput);
        if(searchResults.size() == 0) {
            System.out.println("UNFORTUNATTLY WE DON'T HAVE ANYTHING THAT MATCHS: " + userSearchInput);
            search();
            return;
        }
        
        display(ProductsController.getProducts(userSearchInput));
        System.out.println("[0] -- > Search again\n[1] -- > [1] Go back");
        int userDecision = in.nextInt();

        switch (userDecision) {
            case 0:
                search();
                break;
            case 1:
                NavigationsView.takeOff();
                break;
        
            default:
                break;
        }
    }

    public static void display(ArrayList<Product> products) {
        for(Product product : products) {
            System.out.println("\n[" + product.getId() + "]~~--------------------------------------------------------------------------------------------------------------------------+\n" + 
                 "Title:                " + product.getTitle() + "\n" +
                 "Description:          " + product.getDescription() + "\n$" +
                 "Price:                " + product.getPrice() +
                 "DiscountPercentage:   " + product.getDiscountPercentage() + "\n" +
                 "Rating:               " + product.getRating() + "\n" +
                 "Stock:                " + product.getStock() + "\n" +
                 "Brand:                " + product.getBrand() + "\n" +
                 "Category:             " + product.getCategory() + "\n" +
                 "Thumbnail:            " + product.getThumbnail() + "\n");
                 for(String image : product.getImages()){
                     System.out.println(image + "\n");
            }
        }
            
    }


    public static void display(Product product) {
        ArrayList<Product> productArr = new ArrayList<Product>();
        productArr.add(product);
        display(productArr);
    }

    
    public static void navigateToProduct() {

        System.out.print("Select a product index: ");
        Scanner in = new Scanner(System.in);
        int userDecision = in.nextInt();
        display(ProductsController.getProduct(userDecision));
        System.out.print("[0] --> Go back");
        userDecision = in.nextInt();
        navigate();
    }
}
