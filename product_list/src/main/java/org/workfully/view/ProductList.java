package org.workfully.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.workfully.controllers.Paginator;
import org.workfully.controllers.ProductController;
import org.workfully.models.Product;
import org.workfully.utilities.StringPrinter;

@SuppressWarnings({"resource", "unused"})
public class ProductList {

    private HashMap<Integer, Product> productListByIndex;
    private ArrayList<Product> productList;
    private Paginator paginator;
    private ProductController productController;

    public ProductList(ProductController productController) {
        this.productController = productController;
        this.productList = productController.getProductList();
        this.paginator = productController.getPaginator();
        this.productListByIndex = new HashMap<Integer, Product>() {
            {
                for (Product product : productList) {
                    put(product.getId(), product);
                }
            }
        };
    }

    public void init() {
        showProductList();
        while (true)
            displayNavigationModule();
    }

    /* MAYBE USEFUL IN FUTURE */
    private HashMap<Integer, Product> getProductListByIndex() {
        return productListByIndex;
    }

    /* MAYBE USEFUL IN FUTURE */
    private void setProductListByIndex(HashMap<Integer, Product> productListByIndex) {
        this.productListByIndex = productListByIndex;
    }

    private void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    private void showProductList() {
        for (Product product : this.productList) {
            StringPrinter.println(product.toString());
        }

        showPageStatus();
    }

    private void nextPage() {
        setProductList(productController.generateProductList(this.paginator.nextPage()));
        showProductList();
    }

    private void returnPage() {
        setProductList(productController.generateProductList(this.paginator.returnPage()));
        showProductList();
    }

    private void displayNavigationModule() {
        ProductSelectionUtils.paginatorConditions(this.paginator);

        Scanner sc = new Scanner(System.in);
        char selection = sc.next().toLowerCase().charAt(0);

        selectionNavigationMenu(selection);
    }

    private void selectionNavigationMenu(char selection) {
        final char NEXT = 'e';
        final char RETURN = 'q';
        final char PRODUCT_DETAIL_MENU = 'd';

        switch (selection) {
            case NEXT:
                if (this.paginator.getPagesLeft() > 0) {
                    nextPage();
                }
                break;
            case RETURN:
                if (this.paginator.getPageSelection() > 1) {
                    returnPage();
                    break;
                }
                StringPrinter.print("Bad Input, select again. \n");
                break;
            case PRODUCT_DETAIL_MENU:
                showProductDetailDialogue();
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
                        "Total Pages: " + (this.paginator.getPagesLeft() + this.paginator.getPageSelection()));
    }

    private void showProductDetailDialogue() {
        // StringPrinter.flushConsole();
        StringPrinter.printMultiLn(
                "[1] -> Search by keyword",
                "[2] -> Search by category");
        Scanner sc = new Scanner(System.in);
        try {
            int menuSelection = sc.nextInt();
            selectionMenu(menuSelection);
        } catch (Exception e) {
            StringPrinter.println(e.getMessage());
            showProductDetailDialogue();
        }
    }

    private void selectionMenu(int menuSelection) {
        // final int SEARCH_BY_ID = ;
        final int SEARCH_BY_KEYWORD = 1;
        final int SEARCH_BY_CATEGORY = 2;

        switch (menuSelection) {
            /* UNCOMMENT TO ADD SEARCH BY ID */
            /*
             * case SEARCH_BY_ID:
             * StringPrinter.flushConsole();
             * StringPrinter.print("Select Product ID: ");
             * int productSelection = sc.nextInt();
             * System.out.println(paginator.getProduct(productSelection));
             * displayNavigationModule();
             * break;
             */
            case SEARCH_BY_KEYWORD:
                updateProductList();
                showProductList();
                break;
            case SEARCH_BY_CATEGORY:
                showCategoryList();
                updateProductList(categorySelection());
                showProductList();
                break;
            default:
                StringPrinter.print("Bad Input, select again. \n");
                break;
        }
    }

    private String keywordSelection() {
        Scanner sc = new Scanner(System.in);
        StringPrinter.flushConsole();
        StringPrinter.print("Type keyword: ");
        return sc.next();
    }

    public void showCategoryList() {
        int counter = 0;

        for (Object category : paginator.getCategoryList()) {
            counter++;
            StringPrinter.println("[" + counter + "] -> " + category.toString());
        }
    }

    public int categorySelection() {
        Scanner sc = new Scanner(System.in);
        StringPrinter.print("Select Category: ");
        return sc.nextInt();
    }

    public void updateProductList() {
        setProductList(
                productController.generateProductList(paginator.getProductsByKeyword(keywordSelection())));
        if (productList.isEmpty()) {
            System.out.println("No Results");
            showProductDetailDialogue();
        }
    }

    public void updateProductList(int selection) {
        setProductList(
                productController.generateProductList(
                        paginator.getProductsByCategory(paginator.getCategoryList().getString(selection - 1))));
        if (productList.isEmpty()) {
            System.out.println("No Results");
        }
    }
}