package org.workfully.view.components;

import java.util.ArrayList;
import java.util.Scanner;

import org.workfully.controllers.APIController;
import org.workfully.controllers.ProductController;
import org.workfully.models.Category;
import org.workfully.models.Product;
import org.workfully.utilities.StringPrinter;
import org.workfully.view.BasicView;

public class FilterView extends BasicView {

    private ArrayList<Product> productList;
    private CategoriesList categoriesList;

    // TODO
    public FilterView(ArrayList<Product> productList, CategoriesList categoriesList, APIController apiController) {
        this.productList = productList;
        this.categoriesList = categoriesList;
        this.apiController = apiController;

        init();
    }

    public void init() {
        menuSelection(selectOption());
    }

    @Override
    public void display() {

    }

    public ArrayList<Product> byCategory(Category category) {
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

    private void hasStock(ArrayList<Product> productList) {
        int counter = 0;
        for (Product product : productList) {
            if (product.getStock() > 0) {
                counter++;
                StringPrinter.println(product.toString());
            }
        }
        int total = productList.size() - counter;
        StringPrinter.println("We have filtered out " + total + " products.");
    }

    public static void showMenu() {
        StringPrinter.printMultiLn(
                "[1] -> Filter by category",
                "[2] -> Toggle In Stock");
    }

    public int selectOption() {
        Scanner sc = new Scanner(System.in);
        StringPrinter.println("Select Option: ");
        return sc.nextInt();
    }

    public void menuSelection(int selection) {
        final int FILTER_BY_CATEGORY = 1;
        final int TOGGLE_STOCK = 2;

        switch (selection) {
            case FILTER_BY_CATEGORY:
                categoriesList.display();
                showProductList(byCategory(categoriesList.getCategory(selectOption() - 1)));
                break;
            case TOGGLE_STOCK:
            hasStock(productList);
                break;
            default:
                break;
        }
    }

}
