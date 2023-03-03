package org.workfully.view;

import static org.workfully.utilities.StringPrinter.*;

import java.util.Scanner;

import org.workfully.controllers.Paginator;
import org.workfully.utilities.StringPrinter;

@SuppressWarnings("resource")
public class ProductSelectionUtils {

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
     * @param paginator used to evaluate page status
     *                  shows option according to page status
     */
    public static void paginatorConditions(Paginator paginator) {
        if (paginator.getPageSelection() > 1 && paginator.getPagesLeft() > 0) {
            StringPrinter.printMultiLn(
                    "[E] -> Next Page ",
                    "[Q] -> Previous Page ",
                    "[D] -> Select Product");
            return;
        }

        if (paginator.getPageSelection() <= 1 && paginator.getPagesLeft() > 0) {
            StringPrinter.printMultiLn(
                    "[E] -> Next Page ",
                    "[D] -> Select Product");
            return;

        }

        if (paginator.getPageSelection() > 1 && paginator.getPagesLeft() == 0) {
            StringPrinter.printMultiLn(
                    "[Q] -> Previous Page ",
                    "[D] -> Select Product");
            return;
        }

        StringPrinter.printMultiLn(
                "[D] -> Select Product");
    }
}
