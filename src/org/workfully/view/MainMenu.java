package org.workfully.view;

import java.util.Scanner;

import org.workfully.utilities.exceptions.InvalidUserInputException;

import static org.workfully.utilities.factories.StringFactory.*;

public class MainMenu {

    public void init() {

        try {
            flushConsole();

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
                System.out.println("404 not found, maybe we're still working on this");
                break;
            case 2:
                print("\033[H\033[2J");
                new ExistingUserMenu(this).init();
                break;
            case 3:
                System.exit(0);
            case default:
                print("\033[H\033[2J");
                throw new InvalidUserInputException();
        }
    }
}
