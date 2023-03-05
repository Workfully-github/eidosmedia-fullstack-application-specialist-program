package Projects.Products_List.views;

import java.util.Scanner;

import Projects.Products_List.controllers.PageController;

public class ListingDialog {

    private static final int NEXT_PAGE = 1;
    private static final int PREVIOUS_PAGE = 2;
    private static final int DETAIL = 3; 
    private static final int HOME = 4; 

    public void initiateDialog() {

        Scanner userInput = new Scanner(System.in);
        System.out.println("-------------------------------------------------------");
        System.out.println("What do you want to do next?");
        System.out.println("\n");
        System.out.println("[1] --> Next Page");
        if (!PageController.firstPage()) System.out.println("[2] --> Previous Page");
        System.out.println("[3] --> Product Detail");
        System.out.println("[4] --> Go Back Home");
        System.out.println("\n");
        System.out.print("Your answer: ");

        int userChoice = userInput.nextInt();

        ProductListView list = new ProductListView();
        
        switch (userChoice) {
            case NEXT_PAGE:
                PageController.nextPage();
                list.showList();
                break;
            case PREVIOUS_PAGE:
                PageController.previousPage();
                list.showList();
                break;
            case DETAIL:
                SingleProductDialog detail = new SingleProductDialog();
                detail.chooseSingleProduct();
                initiateDialog();
                break;
            case HOME:
                StartingDialog home = new StartingDialog();
                home.initiateDialog();
                break;
        }
    }
}
