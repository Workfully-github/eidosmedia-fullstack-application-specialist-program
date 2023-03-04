package Projects.Products_List.views;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class SearchBarDialog {

    // DELETE!
    
    private static final String YES = "Y";
    private static final String NO = "N";
    
    public void doSearch(int skip, int limit) throws IOException, ParseException {

        Scanner userInput = new Scanner(System.in);
        System.out.println("-------------------------------------------------------");
        System.out.println("Do you wish to search for any product?");
        System.out.println("\n");
        System.out.println("[Y] --> Yes");
        System.out.println("[N] --> No");
        System.out.println("\n");
        System.out.print("Your answer: ");

        String userChoice = userInput.nextLine();

        SearchBarView searchBarView = new SearchBarView();
        SeeDetailDialog seeDetailDialog = new SeeDetailDialog();
        
        switch (userChoice) {
            case YES:
                //searchBarView.searchBar(skip, limit);

                seeDetailDialog.seeDetail(skip);
                break;
            case NO:
                seeDetailDialog.seeDetail(skip);
                break;
        }
    }
}
