package org.workfully.view;

import static org.workfully.utilities.StringPrinter.*;

import java.util.Scanner;

import org.workfully.controllers.Paginator;
import org.workfully.utilities.StringPrinter;

@SuppressWarnings("resource")
public class ProductSelection {

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

    public static void paginatorConditions(Paginator paginator) {
        if (paginator.getPageSelection() > 1 && paginator.getPagesLeft() > 0) {
            StringPrinter.printMultiLn(
                    "[E] -> Next Page " + "\n" +
                            "[Q] -> Previous Page " + "\n" +
                            "[D] -> Select Product");
        }

        if (paginator.getPageSelection() <= 1) {
            StringPrinter.printMultiLn(
                    "[E] -> Next Page " + "\n" +
                            "[D] -> Select Product");

        }

        if (paginator.getPageSelection() > 1 && paginator.getPagesLeft() == 0) {
            StringPrinter.printMultiLn(
                    "[Q] -> Previous Page " + "\n" +
                            "[D] -> Select Product");
        }
    }
}
