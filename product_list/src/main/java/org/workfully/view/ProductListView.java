package org.workfully.view;

import java.util.ArrayList;
import java.util.Scanner;

import org.workfully.controllers.ProductController;
import org.workfully.models.Product;
import org.workfully.utilities.StringPrinter;
import org.workfully.view.components.CategoriesList;

@SuppressWarnings("resource")
public class ProductListView extends BasicView {

    private ProductController productController;
    private ProductListMenu productListMenuView;
    private CategoriesList categoriesList;
    private ArrayList<Product> productList;

    public ProductListView() {
        this.productController = new ProductController();
        this.categoriesList = new CategoriesList();
        this.productListMenuView = new ProductListMenu(this.apiController, this.categoriesList, this,
                this.navigationSelection);
        this.productList = productController
                .generateProductList(
                        this.apiController.requestProductList(this.navigationSelection.requestAllProducts()));
    }

    @Override
    public void display() {
        displayProductList();
    }

    protected void nextPage() {
        setProductList(this.productController
                .generateProductList(this.apiController.requestProductList(navigationSelection.requestNextPage())));
        showAllProducts(this.productList, true);
    }

    protected void returnPage() {
        setProductList(productController
                .generateProductList(this.apiController.requestProductList(navigationSelection.requestReturnPage())));
        showAllProducts(this.productList, true);
    }

    public void updateProductList() {
        setProductList(
                productController.generateProductList(
                        this.apiController.getProductsByKeyword(
                                navigationSelection.requestProductsByKeyword(keywordSelection()))));
        if (this.productList.isEmpty()) {
            StringPrinter.println("No Results");
            this.productListMenuView.displayProductDetailMenuComponent();
        }
    }

    public void updateProductList(int selection) {
        setProductList(
                productController.generateProductList(
                        apiController.getProductsByCategory(categoriesList.getCategoryName((selection - 1)))));
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

    private void displayProductList() {
        showAllProducts(this.productController
                .generateProductList(
                        this.apiController.requestProductList(this.navigationSelection.requestAllProducts())),
                true);
        while (true)
            this.productListMenuView.displayNavigationModule();
    }
}