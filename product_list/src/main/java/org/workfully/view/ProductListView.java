package org.workfully.view;

import java.util.ArrayList;

import org.workfully.http.APIController;
import org.workfully.controllers.ProductController;
import org.workfully.models.Product;
import org.workfully.utilities.StringPrinter;
import org.workfully.view.components.CategoriesList;

public class ProductListView extends BasicView {

    // FIXME fix productLists 
    private ArrayList<Product> showAllProductsList;
    private ArrayList<Product> dynamicProductList;
    private APIController apiController;
    private ProductController productController;
    private ProductListMenuView productListMenuView;
    private CategoriesList categoriesListView;

    public ProductListView(ProductController productController) {
        this.productController = productController;
        this.showAllProductsList = productController.getAllProductsList();
        this.dynamicProductList = productController.getProductList();
        this.apiController = productController.getAPIController();
        this.categoriesListView = new CategoriesList();
        this.productListMenuView = new ProductListMenuView(apiController, categoriesListView, this);
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
        setProductList(productController.generateProductList(this.apiController.nextPage()));
        showProductList(dynamicProductList);
    }

    protected void returnPage() {
        setProductList(productController.generateProductList(this.apiController.returnPage()));
        showProductList(dynamicProductList);
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
                        apiController.getProductsByKeyword(this.productListMenuView.keywordSelection())));
        if (dynamicProductList.isEmpty()) {
            StringPrinter.println("No Results");
            this.productListMenuView.showProductDetailDialogue();
        }
    }

    public void updateProductList(int selection) {
        setProductList(
                productController.generateProductList(
                        apiController.getProductsByCategory(categoriesListView.getCategory((selection - 1)))));
        if (dynamicProductList.isEmpty()) {
            StringPrinter.println("No Results");
        }
    }

    public void updateProductList(ArrayList<Product> productList) {
        setProductList(productList);
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

    @Override
    public void display() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'display'");
    }
}