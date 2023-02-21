package org.workfully.view;

import java.util.Scanner;

import org.workfully.utilities.exceptions.InvalidUserInputException;

import static org.workfully.utilities.factories.StringFactory.*;

public class MainMenu {

    public void init() {

        try {

            Scanner in = new Scanner(System.in);

            selectionDialogue();

            int option = in.nextInt();

            selectMenu(option);

        } catch (InvalidUserInputException e) {
            printLn("Error: " + e.getMessage());
            init();
        }
    }

    private void selectionDialogue() {

        printMultiLn(
                "Welcome To Sport Social News",
                "[1] -> Create User",
                "[2] -> Select Existing User",
                "[3] -> Exit");
        print("Navigate to: ");
    }

    private void selectMenu(int option) throws InvalidUserInputException {
        switch (option) {
            case 1:
                System.out.println("Option 1");
                break;
            case 2:
                System.out.println("Option 2");
                break;
            case 3:
                System.exit(0);
            case default:
                System.out.print("\033[H\033[2J");
                throw new InvalidUserInputException();
        }
    }
}
