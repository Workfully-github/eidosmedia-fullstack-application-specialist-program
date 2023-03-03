package org.workfully.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.workfully.controllers.Paginator;
import org.workfully.controllers.ProductController;
import org.workfully.models.Product;
import org.workfully.utilities.StringPrinter;

@SuppressWarnings({ "unused" })
public class ProductListView {

    private final ArrayList<Product> showAllProductsList;
    private ArrayList<Product> dynamicProductList;
    private Paginator paginator;
    private ProductController productController;
    private ProductListMenuView productListMenuView;

    public ProductListView(ProductController productController) {
        this.productController = productController;
        this.showAllProductsList = productController.getProductList();
        this.dynamicProductList = productController.getProductList();
        this.paginator = productController.getPaginator();
        this.productListMenuView = new ProductListMenuView(paginator, this);
    }

    public void init() {
        showProductList(showAllProductsList);
        while (true)
            this.productListMenuView.displayNavigationModule();
    }

    /**
     * Shows a different Prodcut List based on @param productList
     */
    protected void showProductList(ArrayList<Product> productList) {
        for (Product product : productList) {
            StringPrinter.println(product.toString());
        }

        showPageStatus();
    }

    protected void nextPage() {
        setProductList(productController.generateProductList(this.paginator.nextPage()));
        showProductList(dynamicProductList);
    }

    protected void returnPage() {
        setProductList(productController.generateProductList(this.paginator.returnPage()));
        showProductList(dynamicProductList);
    }

    private void showPageStatus() {
        StringPrinter.printMultiLn(
                "Current Page: " + this.paginator.getPageSelection() + "\n" +
                        "Pages Left: " + this.paginator.getPagesLeft() + "\n" +
                        "Total Pages: " + (this.paginator.getPagesLeft() + this.paginator.getPageSelection()));
    }

    public void updateProductList() {
        setProductList(
                productController.generateProductList(
                        paginator.getProductsByKeyword(this.productListMenuView.keywordSelection())));
        if (dynamicProductList.isEmpty()) {
            StringPrinter.println("No Results");
            this.productListMenuView.showProductDetailDialogue();
        }
    }

    public void updateProductList(int selection) {
        setProductList(
                productController.generateProductList(
                        paginator.getProductsByCategory(paginator.getCategoryList().getString(selection - 1))));
        if (dynamicProductList.isEmpty()) {
            StringPrinter.println("No Results");
        }
    }

    protected ArrayList<Product> getShowAllProductsList() {
        return showAllProductsList;
    }

    protected ArrayList<Product> getDynamicProductList() {
        return dynamicProductList;
    }

    private void setProductList(ArrayList<Product> dynamicProductList) {
        this.dynamicProductList = dynamicProductList;
    }

}