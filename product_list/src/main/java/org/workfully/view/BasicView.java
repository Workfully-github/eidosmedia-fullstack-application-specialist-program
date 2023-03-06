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
    protected CommandLineTable commandLineTable;

    public BasicView() {
        this.apiController = new APIController();
        this.navigationSelection = new NavigationSelectionUtils(apiController);
        this.commandLineTable = new CommandLineTable();
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

        showPageStatus();
    }

    public void showTableViewProductList(ArrayList<Product> productList) {

        StringPrinter.println("########################################");
        for (Product product : productList) {
            StringPrinter.printMultiLn(
                    "# Title: " + product.getTitle(),
                    "# Price: " + product.getPrice() + "\n" +
                            "# Category: " + product.getCategory());
            StringPrinter.println("########################################");

        }

        showPageStatus();
    }

    public void name () {
        
    }

    private void showPageStatus() {
        StringPrinter.printMultiLn(
                "Current Page: " + this.navigationSelection.getPageSelection() + "\n" +
                        "Pages Left: " + this.navigationSelection.getPagesLeft() + "\n" +
                        "Total Pages: "
                        + (this.navigationSelection.getPagesLeft() + this.navigationSelection.getPageSelection()));
    }

}
