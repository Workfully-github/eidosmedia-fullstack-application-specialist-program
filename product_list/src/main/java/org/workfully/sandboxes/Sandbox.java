package org.workfully.sandboxes;

import org.workfully.controllers.ProductController;
import org.workfully.view.ProductList;
import org.workfully.view.ProductSelection;

/**
 * Hello world!
 *
 */
public class Sandbox {

    public static void main(String[] args) {

        ProductList productList = new ProductList(new ProductController(new ProductSelection().howManyPagesDialogue(), new ProductSelection().pageSelectionDialogue()));
        productList.init();
    }
}
