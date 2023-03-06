package org.workfully.view;

import java.util.Scanner;

import org.workfully.controllers.APIController;
import org.workfully.controllers.ProductController;
import org.workfully.utilities.NavigationSelectionUtils;
import org.workfully.utilities.StringPrinter;
import org.workfully.view.components.CategoriesList;
import org.workfully.view.components.FilterView;
import org.workfully.view.components.ProductDetailMenuComponent;

@SuppressWarnings("resource")
public class ProductListMenu {

    private APIController apiController;
    private ProductListView productListView;
    private ProductDetailMenuComponent productDetailMenuComponent;
    private CategoriesList categoriesList;
    public static final String BAD_INPUT = "Bad Input, select again. \n";

    public ProductListMenu(APIController apiController,
            CategoriesList categoriesListView, ProductListView productListView) {
        this.apiController = apiController;
        this.productListView = productListView;
        this.categoriesList = categoriesListView;
        this.productDetailMenuComponent = new ProductDetailMenuComponent(productListView, categoriesListView);
    }

    protected void displayNavigationModule() {
        NavigationSelectionUtils.apiControllerConditions(this.apiController);

        Scanner sc = new Scanner(System.in);
        char selection = sc.next().toLowerCase().charAt(0);

        selectionNavigationMenu(selection);
    }

    private void selectionNavigationMenu(char selection) {
        final char NEXT = 'e';
        final char RETURN = 'q';
        final char PRODUCT_DETAIL_MENU = 'd';
        final char FILTER = 'f';

        switch (selection) {
            case NEXT:
                if (this.apiController.getPagesLeft() > 0) {
                    productListView.nextPage();
                }
                
                break;
            case RETURN:
                if (this.apiController.getPageSelection() > 1) {
                    productListView.returnPage();
                    break;
                }
                StringPrinter.print(BAD_INPUT);
                break;
            case PRODUCT_DETAIL_MENU:
                StringPrinter.flushConsole();
                productDetailMenuComponent.display();
                break;
            case FILTER:
                FilterView.showMenu();
                new FilterView(productListView.getProductList(), this.categoriesList, this.apiController);
                break;
            default:
                StringPrinter.print(BAD_INPUT);
                break;
        }
    }

    protected void displayProductDetailMenuComponent() {
        productDetailMenuComponent.display();
    }

}
