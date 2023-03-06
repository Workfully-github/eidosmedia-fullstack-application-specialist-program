package Views;

import java.util.ArrayList;
import java.util.Scanner;

import Controllers.NavigationsController;
import Controllers.ProductsController;
import Models.Product;

public class ProductView {
    private static ArrayList<Product> searchResults = new ArrayList<>();

    public static void navigate() {
        Scanner in = new Scanner(System.in);

        display(ProductsController.getProducts(NavigationsController.currentPage));

        System.out.println("Navigate from here:\nCurrent Page [" + NavigationsController.currentPage + "]");

        if (NavigationsController.currentPage != 1)
            System.out.println("[0] --> BACK");
        System.out.println("[1] --> NEXT");
        System.out.println("[2] --> See a product details");
        System.out.println("[3] --> Go back");

        int userDecision = in.nextInt();

        switch (userDecision) {
            case 0:
                if (NavigationsController.currentPage == 1)
                    return;
                NavigationsController.back();
                navigate();
                break;
            case 1:
                if (NavigationsController.currentPage * NavigationsController.limit > 100)
                    return;
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
        if (searchResults.size() == 0) {
            System.out.println("UNFORTUNATTLY WE DON'T HAVE ANYTHING THAT MATCHS: " + userSearchInput);
            search();
            return;
        }

        display(ProductsController.getProducts(userSearchInput));
        System.out.println("[0] -- > Search again\n[1] -- > See a product details\n [2] Go back");
        int userDecision = in.nextInt();

        switch (userDecision) {
            case 0:
                search();
                break;
            case 1:
                navigateToProduct();
                break;
            case 2:
                NavigationsView.takeOff();
                break;

            default:
                break;
        }
    }

    public static void filter() {
        ArrayList<Product> filteredProducts = new ArrayList<>();
        ArrayList<Product> unFilteredProducts = ProductsController.getProducts(NavigationsController.currentPage);
        for (int i = 0; i < unFilteredProducts.size(); i++) {
            if (unFilteredProducts.get(i).getStock() > 50) {
                filteredProducts.add(unFilteredProducts.get(i));
            }
        }
        display(filteredProducts);
        System.out.println("We've filtered out: " + filteredProducts.size() + " products.");
    }

    public static void display(ArrayList<Product> products) {
        System.out.printf(
                "+---------------------------------------------------------------------------------------------------------------------------------------------------+%n");
        System.out.printf("| %-10s   %-45s   %-15s   %-15s   %-30s   %-15s |%n", "ID", "Title", "Price ($)",
                "Discount (%)", "Brand", "Category");
        System.out.printf(
                "+---------------------------------------------------------------------------------------------------------------------------------------------------+%n");
        for (Product product : products) {
            System.out.printf("| %-10s   %-45s   %-15s   %-15s   %-30s   %-15s |%n", product.getId(),
                    product.getTitle(), product.getPrice(), product.getDiscountPercentage(), product.getBrand(),
                    product.getCategory());

            // System.out.println("\n[" + product.getId()
            // +
            // "]~~--------------------------------------------------------------------------------------------------------------------------+\n"
            // +
            // "Title: " + product.getTitle() + "\n" +
            // "Description: " + product.getDescription() + "\n$" +
            // "Price: " + product.getPrice() +
            // "DiscountPercentage: " + product.getDiscountPercentage() + "\n" +
            // "Rating: " + product.getRating() + "\n" +
            // "Stock: " + product.getStock() + "\n" +
            // "Brand: " + product.getBrand() + "\n" +
            // "Category: " + product.getCategory() + "\n" +
            // "Thumbnail: " + product.getThumbnail() + "\n");
            // for (String image : product.getImages()) {
            // System.out.println(image + "\n");
            // }
        }

        System.out.printf(
                "+---------------------------------------------------------------------------------------------------------------------------------------------------+%n");
    }

    public static void displayProductDetails(Product product) {
        System.out.printf(
                "+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+%n");
        System.out.printf("|%-30s   %-135s |%n", "Product Details", "");
        System.out.printf(
                "+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+%n");
        System.out.printf("|%-30s   %-135s |%n", "Title: ", product.getTitle());
        System.out.printf("|%-30s   %-135s |%n", "Description: ", product.getDescription());
        System.out.printf("|%-30s   %-135s |%n", "Price: ", product.getPrice());
        System.out.printf("|%-30s   %-135s |%n", "DiscountPercentage: ", product.getDiscountPercentage());
        System.out.printf("|%-30s   %-135s |%n", "Rating: ", product.getRating());
        System.out.printf("|%-30s   %-135s |%n", "Stock: ", product.getStock());
        System.out.printf("|%-30s   %-135s |%n", "Brand: ", product.getBrand());
        System.out.printf("|%-30s   %-135s |%n", "Category: ", product.getCategory());
        System.out.printf("|%-30s   %-135s |%n", "Thumbnail: ", product.getThumbnail());
        System.out.printf("|%-30s   %-135s |%n", "Images: ", "");
        for (String image : product.getImages()) {
            System.out.printf("|%-30s   %-135s |%n", "      ", image);
        }
        System.out.printf(
                "+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+%n");
    }

    public static void navigateToProduct() {

        System.out.print("Select a product index: ");
        Scanner in = new Scanner(System.in);
        int userDecision = in.nextInt();
        displayProductDetails(ProductsController.getProduct(userDecision));
        System.out.print("[0] --> Go back");
        userDecision = in.nextInt();
        navigate();
    }
}
