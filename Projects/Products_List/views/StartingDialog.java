package Projects.Products_List.views;

import java.util.Scanner;

public class StartingDialog {
    
    private static final int LIST = 1;
    private static final int SEARCH = 2;
    private static final int CATEGORY = 3;

    public void initiateDialog() {

        Scanner userInput = new Scanner(System.in);
        System.out.println("-------------------------------------------------------");
        System.out.println("Welcome to our website");
        System.out.println("\n");
        System.out.println("[1] --> See list of Products");
        System.out.println("[2] --> Search for Product");
        System.out.println("[3] --> Choose a Category");
        System.out.println("\n");
        System.out.print("Your answer: ");

        int userChoice = userInput.nextInt();
        
        switch (userChoice) {
            case LIST:
                ProductListView productListView = new ProductListView();
                productListView.showList();
                initiateDialog();
                break;
            case SEARCH:
                SearchBarView searchBarView = new SearchBarView();
                searchBarView.searchBar();
                initiateDialog();
                break;
            case CATEGORY:
                ChooseCategoryDialog chooseCategoryDialog = new ChooseCategoryDialog();
                chooseCategoryDialog.chooseCategory();
                initiateDialog();
                break;
        }
    }
}
