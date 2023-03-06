package org.workfully.view;

import java.util.ArrayList;

import org.workfully.controllers.APIController;
import org.workfully.models.Product;
import org.workfully.utilities.NavigationSelectionUtils;
import org.workfully.utilities.StringPrinter;
import org.workfully.view.interfaces.Displays;

public abstract class BasicView implements Displays {

    protected APIController apiController;
    protected NavigationSelectionUtils navigationSelection;

    public BasicView() {
        this.apiController = new APIController();
        this.navigationSelection = new NavigationSelectionUtils(apiController);
    }

    /**
     * Shows a different Prodcut List based on @param productList
     */
    public void showProductList(ArrayList<Product> productList) {
        for (Product product : productList) {
            StringPrinter.println(product.toSimpleString());
        }

        showPageStatus();
    }

    public void showDetailedList(ArrayList<Product> productList) {
        for (Product product : productList) {
            StringPrinter.println(product.toString());
        }
    }

    public void showTableViewProductList(ArrayList<Product> productList) {

        for (Product product : productList) {
            productSimpleDetail(product);
        }

        showPageStatus();
    }

    public void showAllProducts(ArrayList<Product> productList, Boolean showPageStatus) {
        CommandLineTable clt = new CommandLineTable();

        StringPrinter.flushConsole();
        clt.setShowVerticalLines(true);
        clt.setHeaders("Product Title", "Product Price", "Product Category");
        for (Product product : productList) {
            clt.addRow(product.getTitle(), product.getPrice() + " Eur", product.getCategory());
        }
        clt.print();

        if(showPageStatus)
        showPageStatus();

    }

    public void showAllProductsCategoryView(ArrayList<Product> productList, Boolean showPageStatus) {
        CommandLineTable clt = new CommandLineTable();

        StringPrinter.flushConsole();
        clt.setShowVerticalLines(true);
        clt.setHeaders("Product Title", "Brand", "Product Price", "Product Category", "Rating", "Stock");
        for (Product product : productList) {
            clt.addRow(product.getTitle(), product.getBrand(), product.getPrice() + " Eur", product.getCategory(), Float.toString(product.getRating()), Integer.toString(product.getStock()));
        }
        clt.print();

        if(showPageStatus)
        showPageStatus();
        
    }

    public void productSimpleDetail(Product product) {
        CommandLineTable clt = new CommandLineTable();

        clt.setShowVerticalLines(true);
        clt.setHeaders("Product", product.getCategory());
        clt.addRow(product.getTitle(), product.getPrice() + " Eur");
        clt.print();

    }

    private void showPageStatus() {
        StringPrinter.printMultiLn(
                "Current Page: " + this.navigationSelection.getPageSelection() + "\n" +
                        "Pages Left: " + this.navigationSelection.getPagesLeft() + "\n" +
                        "Total Pages: "
                        + (this.navigationSelection.getPagesLeft() + this.navigationSelection.getPageSelection()));
    }
}
