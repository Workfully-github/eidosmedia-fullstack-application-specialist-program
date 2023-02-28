package org.workfully.view;

import static org.workfully.utilities.factories.StringFactory.*;
import java.util.Scanner;

import org.workfully.controllers.users.AbstractUserController;
import org.workfully.utilities.Bootstrap;
import org.workfully.utilities.exceptions.InvalidUserInputException;

public class ExistingUserMenu {

    private MainMenu mainMenu;
    private int counter = 2;

    public ExistingUserMenu() {
    }

    public ExistingUserMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void init() {
        start();
    }

    private void start() {
        try {
            flushConsole();

            Scanner in = new Scanner(System.in);

            selectionDialogue();

            int option = in.nextInt();

            selectMenu(option);

        } catch (InvalidUserInputException e) {
            printLn("Error: " + e.getMessage());
            start();
        }
    }

    private void selectionDialogue() {

        counter = 2;
        printLn("Welcome To Sport Social News");
        printLn("This view is only for TEST purposes.");
        printMultiLn("[0]" + " -> " + "Exit");
        printMultiLn("[1]" + " -> " + "Return");
        for (AbstractUserController user : Bootstrap.userMocks()) {
            printMultiLn("[" + counter + "]" + " -> " + user.getName() + " | " + user.getClass().getSimpleName());
            counter++;
        }
        print("Navigate to: ");
        System.out.println(counter);
    }

    private void selectMenu(int option) throws InvalidUserInputException {

        final boolean USER_SELECTED = option > 1 && option <= counter;
        final boolean OUT_OF_BOUNDS = option > counter;
        final int EXIT = 0;
        final int RETURN = 1;

        if (OUT_OF_BOUNDS) {
            flushConsole();
            throw new InvalidUserInputException();
        }
        if (option == EXIT) {
            System.exit(EXIT);
        }
        if (option == RETURN) {
            mainMenu.init();
        }
        if (USER_SELECTED) {
            new WelcomeView(Bootstrap.userMocks().get(option - 2), this).init();
            return;
        }
    }

}
