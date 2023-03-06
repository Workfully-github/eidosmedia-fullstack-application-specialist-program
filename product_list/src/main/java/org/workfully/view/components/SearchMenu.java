package org.workfully.view.components;

import java.util.Scanner;

import org.workfully.utilities.StringPrinter;
import org.workfully.view.BasicView;
import org.workfully.view.ProductListMenu;
import org.workfully.view.ProductListView;

@SuppressWarnings("resource")
public class SearchMenu extends BasicView {

    private ProductListView productListView;
    private CategoriesList categoriesListComponent;

    public SearchMenu(ProductListView productListView, CategoriesList categoriesListComponent) {
        this.productListView = productListView;
        this.categoriesListComponent = categoriesListComponent;
    }

    @Override
    public void display() {
        showProductDetailDialogue();
    }

    protected void showProductDetailDialogue() {
        StringPrinter.printMultiLn(
                "[1] -> Search by keyword",
                "[2] -> Search by category",
                "[3] -> Show All Products");
        Scanner sc = new Scanner(System.in);
        try {
            int menuSelection = sc.nextInt();
            selectionMenu(menuSelection);
        } catch (Exception e) {
            StringPrinter.print(ProductListMenu.BAD_INPUT);
            showProductDetailDialogue();
        }
    }

    private void selectionMenu(int menuSelection) {
        // final int SEARCH_BY_ID = INSERT NUMBER;
        final int SEARCH_BY_KEYWORD = 1;
        final int SEARCH_BY_CATEGORY = 2;
        final int SHOW_ALL_PRODUCTS = 3;

        switch (menuSelection) {
            /* UNCOMMENT TO ADD SEARCH BY ID */
            /*
             * case SEARCH_BY_ID:
             * StringPrinter.flushConsole();
             * StringPrinter.print("Select Product ID: ");
             * int productSelection = sc.nextInt();
             * System.out.println(apiController.getProduct(productSelection));
             * displayNavigationModule();
             * break;
             */
            case SEARCH_BY_KEYWORD:
                productListView.updateProductList();
                productListView.showProductList(productListView.getProductList());
                break;
            case SEARCH_BY_CATEGORY:
                categoriesListComponent.display();
                productListView.updateProductList(categorySelection());
                productListView.showProductList(productListView.getProductList());
                break;
            case SHOW_ALL_PRODUCTS:
                productListView.display();
                break;
            default:
                StringPrinter.flushConsole();
                StringPrinter.print(ProductListMenu.BAD_INPUT);
                showProductDetailDialogue();
                break;
        }
    }

    private int categorySelection() {
        Scanner sc = new Scanner(System.in);
        StringPrinter.print("Select Category: ");
        return sc.nextInt();
    }

}
