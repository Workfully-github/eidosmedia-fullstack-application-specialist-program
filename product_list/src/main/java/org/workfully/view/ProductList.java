package org.workfully.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.workfully.controllers.Paginator;
import org.workfully.controllers.ProductController;
import org.workfully.models.Product;
import org.workfully.utilities.StringPrinter;

public class ProductList {

    private HashMap<Integer, Product> productListByIndex;
    private ArrayList<Product> productList;
    private Paginator paginator;
    private ProductController productController;

    public ProductList(ProductController productController) {
        this.productController = productController;
        this.productList = productController.getProductList();
        this.productListByIndex = new HashMap<Integer, Product>();
        this.paginator = productController.getPaginator();

        /*
         * Populates the HashMap with the Product List
         * So we can access products by Index if needed
         */
        for (Product product : productList) {
            productListByIndex.put(product.getId(), product);
        }
    }

    public void init() {
        presentAllProducts();
        while (true)
            pageNavigation();
    }

    public HashMap<Integer, Product> getProductListByIndex() {
        return productListByIndex;
    }

    public void setProductListByIndex(HashMap<Integer, Product> productListByIndex) {
        this.productListByIndex = productListByIndex;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public void presentAllProducts() {
        for (Product product : productList) {
            StringPrinter.println(product.toString());
        }

       showPageStatus();
    }

    public void nextPage() {
        this.productList = productController.generateProductList(paginator.nextPage());
        presentAllProducts();
    }

    public void returnPage() {
        this.productList = productController.generateProductList(paginator.returnPage());
        presentAllProducts();
    }

    public void pageNavigation() {
        Scanner sc = new Scanner(System.in);
        StringPrinter.printMultiLn(
                "[E] -> Next Page " + "\n" +
                        "[Q] -> Previous Page ");

        char selection = sc.next().toLowerCase().charAt(0);
        selectionNavigationMenu(selection);
    }

    private void selectionNavigationMenu(char selection) {
        final char NEXT = 'e';
        final char RETURN = 'q';

        switch (selection) {
            case NEXT:
                if (paginator.getPagesLeft() > 0) {
                    nextPage();
                }
                break;
            case RETURN:
                if (paginator.getPageSelection() > 1) {
                    returnPage();
                    break;
                }
                StringPrinter.print("Bad Input, select again. \n");
                break;
            default:
                StringPrinter.print("Bad Input, select again. \n");
                break;
        }
    }

    private void showPageStatus() {
        StringPrinter.printMultiLn(
                "Current Page: " + this.paginator.getPageSelection() + "\n" +
                        "Pages Left: " + this.paginator.getPagesLeft() + "\n" +
                        "Total Pages: " + this.paginator.getTotalPages());
    }

}
