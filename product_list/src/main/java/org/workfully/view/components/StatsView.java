package org.workfully.view.components;

import java.util.Scanner;

import org.workfully.controllers.StatsController;
import org.workfully.utilities.StringPrinter;

public class StatsView {

    private StatsController statsController;

    public void displayStats() {
        showStats();
    }
    
    private void showStats() {

    }

    public void showStatsDialog() {

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
    }
}
