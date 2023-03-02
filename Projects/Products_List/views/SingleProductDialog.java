package Projects.Products_List.views;

import java.util.Scanner;

public class SingleProductDialog {
    
    public int chooseSingleProduct() {

        Scanner userInput = new Scanner(System.in);
        System.out.println("-------------------------------------------------------");
        System.out.println("Please select the ID of the product that you want:");
        System.out.println("\n");
        System.out.print("From 1 to 100: ");

        int userChoice = userInput.nextInt();

        return userChoice;
    }
}
