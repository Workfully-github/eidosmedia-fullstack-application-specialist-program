package org.workfully.view.components;

import java.util.ArrayList;
import java.util.Scanner;

import org.workfully.controllers.APIController;
import org.workfully.models.Category;
import org.workfully.models.Product;
import org.workfully.utilities.StringPrinter;
import org.workfully.view.BasicView;
import org.workfully.view.ProductListView;

@SuppressWarnings("resource")
public class FilterView extends BasicView {

    private ArrayList<Product> productList;
    private CategoriesList categoriesList;
    private ProductListView productListView;

    /**
     * Initialization of {@link #FilterView()} starts with provided @param productList
     * @param productList is manipulated by {@link #filterByCategory(Category category)} and {@link #filterByStock(int, ArrayList)}
     * @param productListView is required to return to previous menu by calling {@link ProductListView#display()}
     */
    public FilterView(ArrayList<Product> productList, CategoriesList categoriesList, APIController apiController,
            ProductListView productListView) {
        this.productList = productList;
        this.categoriesList = categoriesList;
        this.apiController = apiController;
        this.productListView = productListView;

        display();
    }

    @Override
    public void display() {
        init();
    }

    private void init() {
        showMenu();
        menuSelection(selectOption());
    }

    private ArrayList<Product> filterByCategory(Category category) {
        return new ArrayList<Product>() {
            {
                for (Product product : productList) {
                    if (product.getCategory().equals(category.getName())) {
                        add(product);
                    }
                }
            }
        };
    }

    private void filterByStock(int amount, ArrayList<Product> list) {
        ArrayList<Product> stockList = new ArrayList<Product>() {
            {
                for (Product product : list) {
                    if (product.getStock() > amount) {
                        add(product);
                    }
                }
            }
        };

        showAllProductsCategoryView(stockList, false);

        StringPrinter
                .println("We have filtered out " + Integer.toString(list.size() - stockList.size()) + " products.");
    }

    private int selectOption() {
        Scanner sc = new Scanner(System.in);
        StringPrinter.println("Select Option: ");
        return sc.nextInt();
    }

    private int selectStockAmount() {
        Scanner sc = new Scanner(System.in);
        StringPrinter.println("Select Amount of Stock you want to filter by:");
        return sc.nextInt();
    }

    private ArrayList<Product> getListByCategory() {
        this.productList = filterByCategory(categoriesList.getCategory(selectOption() - 1));
        return productList;
    }

    private ArrayList<Product> getProductList() {
        return productList;
    }

    public static void showMenu() {
        StringPrinter.printMultiLn(
                "[1] -> Filter by category",
                "[2] -> Toggle In Stock",
                "[3] -> Toggle Filters Off");
    }

    private void menuSelection(int selection) {
        final int FILTER_BY_CATEGORY = 1;
        final int TOGGLE_STOCK = 2;
        final int TOGGLE_OFF = 3;

        switch (selection) {
            case FILTER_BY_CATEGORY:
                categoriesList.display();
                showAllProductsCategoryView(getListByCategory(), false);
                init();
                break;
            case TOGGLE_STOCK:
                filterByStock(selectStockAmount(), getProductList());
                init();
                break;
            case TOGGLE_OFF:
                productListView.display();
                break;
            default:
                break;
        }
    }
}
