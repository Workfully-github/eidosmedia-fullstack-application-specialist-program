package org.workfully.view;

import java.util.ArrayList;
import java.util.Scanner;

import org.workfully.controllers.APIController;
import org.workfully.controllers.ProductController;
import org.workfully.models.Product;
import org.workfully.utilities.StringPrinter;
import org.workfully.view.components.CategoriesList;

public class ProductListView extends BasicView {

    private ProductController productController;
    private ProductListMenu productListMenuView;
    private APIController apiController;
    private CategoriesList categoriesList;

    private ArrayList<Product> productList;

    public ProductListView() {
        this.productController = new ProductController();
        this.categoriesList = new CategoriesList();
        this.apiController = new APIController();
        this.productListMenuView = new ProductListMenu(productController, apiController, categoriesList, this);
        
    }

    @Override
    public void display() {
        showProductList(productController.generateProductList(apiController.getAllProducts()));
        while (true)
            this.productListMenuView.displayNavigationModule();
    }

    /**
     * Shows a different Prodcut List based on @param productList
     */
    public void showProductList(ArrayList<Product> productList) {
        for (Product product : productList) {
            StringPrinter.println(product.toString());
        }

        showPageStatus();
    }

    protected void nextPage() {
        setProductList(productController.generateProductList(this.apiController.nextPage()));
        showProductList(productList);
    }

    protected void returnPage() {
        setProductList(productController.generateProductList(this.apiController.returnPage()));
        showProductList(productList);
    }

    private void showPageStatus() {
        StringPrinter.printMultiLn(
                "Current Page: " + this.apiController.getPageSelection() + "\n" +
                        "Pages Left: " + this.apiController.getPagesLeft() + "\n" +
                        "Total Pages: " + (this.apiController.getPagesLeft() + this.apiController.getPageSelection()));
    }

    public void updateProductList() {
        setProductList(
                productController.generateProductList(
                        apiController.getProductsByKeyword(keywordSelection())));
        if (productList.isEmpty()) {
            StringPrinter.println("No Results");
            this.productListMenuView.displayProductDetailMenuComponent();
        }
    }

    public void updateProductList(int selection) {
        setProductList(
                productController.generateProductList(
                        apiController.getProductsByCategory(categoriesList.getCategory((selection - 1)))));
        if (productList.isEmpty()) {
            StringPrinter.println("No Results");
        }
    }

    public void updateProductList(ArrayList<Product> productList) {
        setProductList(productList);
        if (productList.isEmpty()) {
            StringPrinter.println("No Results");
        }
    }

    private void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    private String keywordSelection() {
        Scanner sc = new Scanner(System.in);
        StringPrinter.flushConsole();
        StringPrinter.print("Type keyword: ");
        return sc.next();
    }
}