package org.workfully.view.components;
import java.util.Scanner;
import org.workfully.controllers.StatsController;
import org.workfully.utilities.StringPrinter;
public class StatsView {
    private StatsController statsController;
    public void displayStats() {
        showStats();
        showTotalCalls();
        showPercentageStats();
    }
    
    private void showStats() {
        StringPrinter.println("The number of times each API was called:");
        StringPrinter.printMultiLn(
            "Number of calls to get the products list: " + statsController.getStat().getPageRequests(),
            "Number of calls to get the complete products list: " + statsController.getStat().getAllProductsRequests(),
            "Number of calls to get the detail of a product: " + statsController.getStat().getProductDetailsRequests(),
            "Number of calls to search for products: " + statsController.getStat().getSearchRequests(),
            "Number of calls to search by category: " + statsController.getStat().getSearchByCategoryRequests(),
            "Number of calls to get the categories list: " + statsController.getStat().getCategoriesRequests());
    }
    private void showTotalCalls() {
        System.out.printf("%S", "The total number of calls is " + statsController.getStat().getTotalCalls());
    }
    private void showPercentageStats() {
        StringPrinter.println("The percentage of each API calling:");
        StringPrinter.printMultiLn(
            "% of products list: " + statsController.getStat().percentagePageRequests(),
            "% of complete products list: " + statsController.getStat().percentageAllProductsRequests(),
            "% of detail of a product: " + statsController.getStat().percentageProductDetailsRequests(),
            "% of searches for products: " + statsController.getStat().percentageSearchRequests(),
            "% of searches by category: " + statsController.getStat().percentageSearchByCategoryRequests(),
            "% of categories list: " + statsController.getStat().percentageCategoriesRequests());
    }
    /* public void showStatsDialog() {
        StringPrinter.printMultiLn(
                "[1] -> See API call statistics",
                "[2] -> Skip statistics");
        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();
        selectionMenu(selection);
    }
    public void selectionMenu(int selection) {
        
        final int SEE_STATS = 1;
        final int SKIP_STATS = 2;
        switch (selection) {
            case SEE_STATS:
                
                break;
            case SKIP_STATS:
                
                break;
        }
    } */
}
