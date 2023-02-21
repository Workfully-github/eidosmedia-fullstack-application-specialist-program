package org.workfully.view;

import java.util.Scanner;

import org.workfully.controllers.users.AbstractUserController;
import org.workfully.controllers.users.AuthorController;
import org.workfully.utilities.exceptions.InvalidUserInputException;

import static org.workfully.utilities.factories.StringFactory.*;

public class WelcomeView {

    AbstractUserController abstractUserController;
    ExistingUserMenu existingUserMenu;

    public WelcomeView(AbstractUserController abstractUserController, ExistingUserMenu existingUserMenu) {
        this.abstractUserController = abstractUserController;
        this.existingUserMenu = existingUserMenu;
    }

    public void init() {
        start();
    }

    private void start() {
        //FIXME
        if (abstractUserController instanceof AuthorController) {
            doIfAuthor();
        }
    }

    private void selectionDialogue() {
        flushConsole();
        printMultiLn(
                "Welcome Author: " + abstractUserController.getName(),
                "Select an option",
                "[0] -> View Home Section",
                "[1] -> View Personal Section",
                "[2] -> Create content",
                "[3] -> Return",
                "[4] -> Exit");
        print("Navigate to: ");

    }

    private void selectMenu(int option) throws InvalidUserInputException {
        final int RETURN = 3;
        final int EXIT = 4;

        switch (option) {
            case SECTION_HOME:
                break;
            case SECTION_AUTHORS:
                break;
            case SECTION_CREATE:

                break;
            case RETURN:
                existingUserMenu.init();
                break;
            case EXIT:
                System.exit(0);
            case default:
                print("\033[H\033[2J");
                throw new InvalidUserInputException();

        }
    }

    private void doIfAuthor() {

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

}
