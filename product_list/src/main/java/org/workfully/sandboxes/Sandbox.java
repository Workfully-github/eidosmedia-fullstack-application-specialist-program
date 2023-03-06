package org.workfully.sandboxes;

import org.workfully.view.ProductListView;

public class Sandbox {

    public static void main(String[] args) {

        //ProductList view = new ProductList(new ProductController(new ProductSelection().howManyPagesDialogue(), new ProductSelection().pageSelectionDialogue()));
        ProductListView view = new ProductListView();
        view.display();
    }
}
