package org.workfully.view;

import static org.workfully.utilities.StringPrinter.*;

import java.util.Scanner;

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

    
}
