package org.workfully.view;

import java.util.Scanner;

import org.workfully.http.APIController;
import org.workfully.utilities.NavigationSelectionUtils;
import org.workfully.utilities.StringPrinter;
import org.workfully.view.components.CategoriesList;
import org.workfully.view.components.FilterView;
import org.workfully.view.components.SearchMenu;

@SuppressWarnings("resource")
public class ProductListMenu {

    private APIController apiController;
    private NavigationSelectionUtils navigationSelectionUtils;
    private ProductListView productListView;
    private SearchMenu productDetailMenuComponent;
    private CategoriesList categoriesList;
    public static final String BAD_INPUT = "Bad Input, select again. \n";

    public ProductListMenu(APIController apiController,
            CategoriesList categoriesListView, ProductListView productListView,
            NavigationSelectionUtils navigationSelectionUtils) {
        this.apiController = apiController;
        this.productListView = productListView;
        this.categoriesList = categoriesListView;
        this.navigationSelectionUtils = navigationSelectionUtils;
        this.productDetailMenuComponent = new SearchMenu(productListView, categoriesListView);
    }

    protected void displayNavigationModule() {
        navigationSelectionUtils.apiControllerConditions(this.apiController);

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
                next();
                break;
            case RETURN:
                back();
                break;
            case PRODUCT_DETAIL_MENU:
                StringPrinter.flushConsole();
                productDetailMenuComponent.display();
                break;
            case FILTER:
                new FilterView(productListView.getProductList(), this.categoriesList, this.apiController,
                        productListView);
                break;
            default:
                StringPrinter.print(BAD_INPUT);
                break;
        }
    }

    private void next() {
        if (this.navigationSelectionUtils.getPagesLeft() > 0) {
            productListView.nextPage();
        }
    }

    private void back() {
        if (this.navigationSelectionUtils.getPageSelection() > 1) {
            productListView.returnPage();
            return;
        }
        StringPrinter.print(BAD_INPUT);
    }

    protected void displayProductDetailMenuComponent() {
        productDetailMenuComponent.display();
    }

}
