package org.workfully.view.components;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.workfully.http.APIController;
import org.workfully.models.Category;
import org.workfully.models.Product;
import org.workfully.utilities.StringPrinter;
import org.workfully.view.BasicView;
import org.workfully.view.ProductListView;

@SuppressWarnings("resource")
public class FilterView extends BasicView {

    private ArrayList<Product> dynamicProductList;
    private ArrayList<Product> mainList;
    private CategoriesList categoriesList;
    private ProductListView productListView;

    /**
     * Initialization of {@link #FilterView()} starts with provided @param
     * dynamicProductList
     * 
     * @param dynamicProductList is manipulated by
     *                           {@link #filterByCategory(Category category)} and
     *                           {@link #filterByStock(int, ArrayList)}
     * @param productListView    is required to return to previous menu by calling
     *                           {@link ProductListView#display()}
     */
    public FilterView(ArrayList<Product> dynamicProductList, CategoriesList categoriesList, APIController apiController,
            ProductListView productListView) {
        this.dynamicProductList = dynamicProductList;
        this.categoriesList = categoriesList;
        this.apiController = apiController;
        this.productListView = productListView;
        this.mainList = productListView.getMainList();

        display();
    }

    @Override
    public void display() {
        init();
    }

    private void init() {
        showMenu();
        try {
            menuSelection(selectOption());
        } catch (Exception e) {
            System.out.println("Bad Input");
            init();
        }
    }

    private ArrayList<Product> filterByCategory(Category category) {
        return new ArrayList<Product>() {
            {
                for (Product product : mainList) {
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
                .println("Filtered out " + Integer.toString(list.size() - stockList.size()) + " products.");
    }

    private int selectOption() throws InputMismatchException {

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
        this.dynamicProductList = filterByCategory(categoriesList.getCategory(selectOption() - 1));
        return dynamicProductList;
    }

    private ArrayList<Product> getProductList() {
        return dynamicProductList;
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
                System.out.println("Bad Input");
                break;
        }
    }
}
