package HttpExercise.Views;

import java.net.URL;
import java.util.Scanner;

public class UserInputView {
    
    public String askUserInput() {

        Scanner userInput = new Scanner(System.in);
        System.out.println("-----------------------------------------------");
        System.out.println("Please insert an URL of your chosing...");
        System.out.print("Your URL is: ");

        String userChoice = userInput.nextLine();

        return userChoice;
    }
}
