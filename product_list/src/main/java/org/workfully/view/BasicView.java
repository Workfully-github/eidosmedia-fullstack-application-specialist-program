package org.workfully.view;

import java.util.ArrayList;

import org.workfully.controllers.APIController;
import org.workfully.models.Product;
import org.workfully.utilities.StringPrinter;
import org.workfully.view.interfaces.Displays;

public abstract class BasicView implements Displays {

    protected APIController apiController;

    public BasicView() {
        this.apiController = new APIController();
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

    private void showPageStatus() {
        StringPrinter.printMultiLn(
                "Current Page: " + this.apiController.getPageSelection() + "\n" +
                        "Pages Left: " + this.apiController.getPagesLeft() + "\n" +
                        "Total Pages: " + (this.apiController.getPagesLeft() + this.apiController.getPageSelection()));
    }

}
