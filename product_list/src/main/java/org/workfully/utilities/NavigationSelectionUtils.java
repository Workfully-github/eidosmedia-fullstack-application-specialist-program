package org.workfully.utilities;

import static org.workfully.utilities.StringPrinter.*;

import java.util.Scanner;

import org.json.JSONObject;
import org.workfully.controllers.APIController;

@SuppressWarnings("resource")
public class NavigationSelectionUtils {

    private final String BASE_URL = "https://dummyjson.com/products";
    private final String CATEGORY_FEATURE = "/category";
    private final String SEARCH_FEATURE = "/search?q=";
    private JSONObject json;
    private int pageSelection;
    private int pageIndex;
    private int skip;
    private int valuesPerPage;

    public int howManyPagesDialogue() {
        Scanner sc = new Scanner(System.in);
        println("How many values per page do you want to see?");
        int valuesPerPage = sc.nextInt();

        return valuesPerPage;
    }

    public int pageSelectionDialogue() {
        Scanner sc = new Scanner(System.in);
        println("What page do you want to see?");
        int pageSelection = sc.nextInt();

        return pageSelection;
    }

    /**
     * @param apiController used to validate page status
     *                      shows option according to page status
     */
    public static void apiControllerConditions(APIController apiController) {
        if (apiController.getPageSelection() > 1 && apiController.getPagesLeft() > 0) {
            StringPrinter.printMultiLn(
                    "[E] -> Next Page ",
                    "[Q] -> Previous Page ",
                    "[D] -> Search",
                    "[F] -> Filter");
            return;
        }

        if (apiController.getPageSelection() <= 1 && apiController.getPagesLeft() > 0) {
            StringPrinter.printMultiLn(
                    "[E] -> Next Page ",
                    "[D] -> Search",
                    "[F] -> Filter");
            return;

        }

        if (apiController.getPageSelection() > 1 && apiController.getPagesLeft() == 0) {
            StringPrinter.printMultiLn(
                    "[Q] -> Previous Page ",
                    "[D] -> Search",
                    "[F] -> Filter");
            return;
        }

        StringPrinter.printMultiLn(
                "[D] -> Search",
                "[F] -> Filter");
    }

    public String requestAllProducts() {
        this.pageSelection = 1;
        this.pageIndex = this.pageSelection - 1;
        this.valuesPerPage = 30;
        this.skip = pageIndex * valuesPerPage;
        return this.BASE_URL + SEARCH_FEATURE + "&limit=" + this.valuesPerPage + "&skip="
        + this.skip;
    }

    public String requestNextPage() {
        this.pageIndex++;
        this.pageSelection = this.pageIndex + 1;
        this.skip = this.pageIndex * this.valuesPerPage;
        return this.BASE_URL + SEARCH_FEATURE + "&limit=" + this.valuesPerPage + "&skip="
        + this.skip;
    }

    public String requestReturnPage() {
        this.pageIndex--;
        this.pageSelection = this.pageIndex + 1;
        this.skip = this.pageIndex * this.valuesPerPage;
        return this.BASE_URL + SEARCH_FEATURE + "&limit=" + this.valuesPerPage + "&skip="
        + this.skip;
    }
}
