package org.workfully.view;

import java.util.Scanner;

import org.workfully.http.APIController;
import org.workfully.utilities.StringPrinter;

@SuppressWarnings("resource")
public class ProductListMenuView {

    private APIController paginator;
    private ProductListView productListView;
    private final String BAD_INPUT = "Bad Input, select again. \n";

    public ProductListMenuView(APIController paginator, ProductListView productListView) {
        this.paginator = paginator;
        this.productListView = productListView;
    }

    protected void displayNavigationModule() {
        ProductSelectionUtils.paginatorConditions(this.paginator);

        Scanner sc = new Scanner(System.in);
        char selection = sc.next().toLowerCase().charAt(0);

        selectionNavigationMenu(selection);
    }

    private void selectionNavigationMenu(char selection) {
        final char NEXT = 'e';
        final char RETURN = 'q';
        final char PRODUCT_DETAIL_MENU = 'd';

        switch (selection) {
            case NEXT:
                if (this.paginator.getPagesLeft() > 0) {
                    productListView.nextPage();
                }
                break;
            case RETURN:
                if (this.paginator.getPageSelection() > 1) {
                    productListView.returnPage();
                    break;
                }
                StringPrinter.print(BAD_INPUT);
                break;
            case PRODUCT_DETAIL_MENU:
                StringPrinter.flushConsole();
                showProductDetailDialogue();
                break;
            default:
                StringPrinter.print(BAD_INPUT);
                break;
        }
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
            StringPrinter.print(BAD_INPUT);
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
             * System.out.println(paginator.getProduct(productSelection));
             * displayNavigationModule();
             * break;
             */
            case SEARCH_BY_KEYWORD:
                productListView.updateProductList();
                productListView.showProductList(productListView.getDynamicProductList());
                break;
            case SEARCH_BY_CATEGORY:
                showCategoryList();
                productListView.updateProductList(categorySelection());
                productListView.showProductList(productListView.getDynamicProductList());
                break;
            case SHOW_ALL_PRODUCTS:
                productListView.updateProductList(productListView.getShowAllProductsList());
                productListView.showProductList(productListView.getDynamicProductList());
                
                break;
            default:
                StringPrinter.flushConsole();
                StringPrinter.print(BAD_INPUT);
                showProductDetailDialogue();
                break;
        }
    }

    protected String keywordSelection() {
        Scanner sc = new Scanner(System.in);
        StringPrinter.flushConsole();
        StringPrinter.print("Type keyword: ");
        return sc.next();
    }

    public void showCategoryList() {
        int counter = 0;

        for (Object category : paginator.getCategoryList()) {
            counter++;
            StringPrinter.println("[" + counter + "] -> " + category.toString());
        }
    }

    public int categorySelection() {
        Scanner sc = new Scanner(System.in);
        StringPrinter.print("Select Category: ");
        return sc.nextInt();
    }
}
