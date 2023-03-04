package Projects.Products_List.views;

import java.util.Scanner;

import Projects.Products_List.controllers.PageController;

public class StartingDialog {
    
    private static final int LIST = 1;
    private static final int SEARCH = 2;
    private static final int CATEGORY = 3;

    
    public void initiateDialog() {

        //PageController pageController = new PageController();

        Scanner userInput = new Scanner(System.in);
        System.out.println("-------------------------------------------------------");
        System.out.println("Welcome to our website");
        System.out.println("\n");
        System.out.println("[1] --> See list of Products");
        System.out.println("[2] --> Search for Product");
        System.out.println("[3] --> Choose a Category");
        
        // Validate if is the first page
        /* System.out.println("[1] --> Next Page");
        System.out.println("[2] --> Previous Page");
        System.out.println("[3] --> Product Detail");
        System.out.println("[4] --> Search for Product");
        System.out.println("[5] --> Choose a Category"); */
        System.out.println("\n");
        System.out.print("Your answer: ");

        int userChoice = userInput.nextInt();
        
        switch (userChoice) {
            case LIST:
                // list first products
                ProductListView productListView = new ProductListView();
                productListView.showList();
                // dialog to move to next page or see detail
                /* ListingDialog listingDialog = new ListingDialog();
                listingDialog.initiateDialog(); */
                // run this method again
                initiateDialog();
                break;
            case SEARCH:
                SearchBarView searchBarView = new SearchBarView();
                searchBarView.searchBar();
                initiateDialog();
                break;
            case CATEGORY:
                
                initiateDialog();
                break;
        }
    }
}
