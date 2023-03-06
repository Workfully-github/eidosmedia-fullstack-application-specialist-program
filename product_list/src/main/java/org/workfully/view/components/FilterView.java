package org.workfully.view.components;

import java.util.ArrayList;
import java.util.Scanner;

import org.workfully.controllers.APIController;
import org.workfully.models.Category;
import org.workfully.models.Product;
import org.workfully.utilities.StringPrinter;
import org.workfully.view.BasicView;
import org.workfully.view.ProductListView;

public class FilterView extends BasicView {

    private ArrayList<Product> productList;
    private CategoriesList categoriesList;
    private ProductListView productListView;

    public FilterView(ArrayList<Product> productList, CategoriesList categoriesList, APIController apiController,
            ProductListView productListView) {
        this.productList = productList;
        this.categoriesList = categoriesList;
        this.apiController = apiController;
        this.productListView = productListView;

        display();
    }

    private void init() {
        showMenu();
        menuSelection(selectOption());
    }

    // TODO Refactor
    @Override
    public void display() {
        init();
    }

    private ArrayList<Product> byCategory(Category category) {
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

    private void hasStock(int amount, ArrayList<Product> list) {
        int counter = 0;

        ArrayList<Product> stockList = new ArrayList<>();

        for (Product product : list) {
            if (product.getStock() > amount) {
                counter++;
                stockList.add(product);
            }
        }

        showAllProductsCategoryView(stockList, false);

        int total = list.size() - counter;

        StringPrinter.println("We have filtered out " + total + " products.");
    }

    public static void showMenu() {
        StringPrinter.printMultiLn(
                "[1] -> Filter by category",
                "[2] -> Toggle In Stock",
                "[3] -> Toggle Filters Off");
    }

    public int selectOption() {
        Scanner sc = new Scanner(System.in);
        StringPrinter.println("Select Option: ");
        return sc.nextInt();
    }

    public int selectStockAmount() {
        Scanner sc = new Scanner(System.in);
        StringPrinter.println("Select Amount of Stock you want to filter by:");
        return sc.nextInt();
    }

    public void menuSelection(int selection) {
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
                hasStock(selectStockAmount(), getProductList());
                init();
                break;
            case TOGGLE_OFF:
                productListView.display();
                break;
            default:
                break;
        }
    }

    public ArrayList<Product> getListByCategory() {
        ArrayList<Product> test = byCategory(categoriesList.getCategory(selectOption() - 1));
        setProductList(test);
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public CategoriesList getCategoriesList() {
        return categoriesList;
    }

}
