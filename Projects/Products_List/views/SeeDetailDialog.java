package Projects.Products_List.views;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class SeeDetailDialog {

    private static final String YES = "Y";
    private static final String NO = "N";
    
    public void seeDetail(int skip) throws IOException, ParseException {

        // DELETE

        Scanner userInput = new Scanner(System.in);
        System.out.println("-------------------------------------------------------");
        System.out.println("Do you wish to see the detail of any product?");
        System.out.println("\n");
        System.out.println("[Y] --> Yes");
        System.out.println("[N] --> No");
        System.out.println("\n");
        System.out.print("Your answer: ");

        String userChoice = userInput.nextLine();
        ChangePageDialog changePageDialog = new ChangePageDialog();

        
        switch (userChoice) {
            case YES:
                SingleProductDialog singleProductDialog = new SingleProductDialog();
                ProductView productView = new ProductView();
                //productView.showSingleProduct(singleProductDialog.chooseSingleProduct());

                changePageDialog.choosePage(skip);
                break;
            case NO:
                changePageDialog.choosePage(skip);
                break;
        }
    }
}
