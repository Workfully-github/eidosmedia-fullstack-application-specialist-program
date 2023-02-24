package HttpExercise.Views;

import java.util.Scanner;

public class UserActionView {
    
    public String askUserAction() {

        Scanner userInput = new Scanner(System.in);
        System.out.println("-----------------------------------------------");
        System.out.println("Please insert an the action you wish to perform (GET / POST)...");
        System.out.print("Your action is: ");

        String userChoice = userInput.nextLine();

        return userChoice;
    }
}
