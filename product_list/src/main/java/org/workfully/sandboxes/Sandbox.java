package org.workfully.sandboxes;

import org.workfully.controllers.ProductController;
import org.workfully.view.ProductList;
import org.workfully.view.ProductSelection;

public class Sandbox {

    public static void main(String[] args) {

        //ProductList productList = new ProductList(new ProductController(new ProductSelection().howManyPagesDialogue(), new ProductSelection().pageSelectionDialogue()));
        ProductList productList = new ProductList(new ProductController(30, 1));
        productList.init();
    }
}
