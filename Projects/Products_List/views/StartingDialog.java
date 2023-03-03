package Projects.Products_List.views;

import java.util.Scanner;

public class StartingDialog {
    
    private static final int NEXT_PAGE = 1;
    private static final int PREVIOUS_PAGE = 2;
    private static final int DETAIL = 3;
    private static final int SEARCH = 4;
    private static final int CATEGORY = 4;
    
    public void doSearch(int skip, int limit) {

        Scanner userInput = new Scanner(System.in);
        System.out.println("-------------------------------------------------------");
        System.out.println("Welcome to our website");
        System.out.println("\n");
        System.out.println("[1] --> Next Page");
        System.out.println("[2] --> Previous Page");
        System.out.println("[3] --> Product Detail");
        System.out.println("[4] --> Search for Product");
        System.out.println("[5] --> Choose a Category");
        System.out.println("\n");
        System.out.print("Your answer: ");

        int userChoice = userInput.nextInt();

        SearchBarView searchBarView = new SearchBarView();
        SeeDetailDialog seeDetailDialog = new SeeDetailDialog();
        
        switch (userChoice) {
            case NEXT_PAGE:
                
                break;
            case PREVIOUS_PAGE:
                
                break;
        }
    }
}
