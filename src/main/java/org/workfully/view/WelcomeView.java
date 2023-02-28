package org.workfully.view;

import java.util.Scanner;

import org.workfully.controllers.users.AbstractUserController;
import org.workfully.controllers.users.AuthorController;
import org.workfully.controllers.users.BasicUserController;
import org.workfully.utilities.exceptions.InvalidUserInputException;
import org.workfully.view.userSection.AuthorClientSideView;

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

        doIfAuthor();
        doIfBasicUser();

    }

    private void authorSelectionDialogue() {
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

    private void basicUserSelectionDialogue() {
        flushConsole();
        printMultiLn(
                "Welcome Author: " + abstractUserController.getName(),
                "Select an option",
                "[0] -> View Home Section",
                "[1] -> Return",
                "[2] -> Exit");
        print("Navigate to: ");
    }

    private void basicUserSelectionMenu(int option) throws InvalidUserInputException {
        final int RETURN = 1;
        final int EXIT = 2;

        switch (option) {
            case SECTION_HOME:
                break;
            case RETURN:
                existingUserMenu.init();
                break;
            case EXIT:
                System.exit(0);
            default:
                flushConsole();
                throw new InvalidUserInputException();
        }
    }

    private void authorSelectMenu(int option) throws InvalidUserInputException {
        final int RETURN = 3;
        final int EXIT = 4;

        switch (option) {
            case SECTION_HOME:
                new AuthorClientSideView(((AuthorController) abstractUserController)).showHomeFeed();
                System.out.println("The best way to get a project done faster is to start sooner. - Jim Highsmith");
                break;
            case SECTION_AUTHORS:
                new AuthorClientSideView(((AuthorController) abstractUserController)).showAuthorSection();
                break;
            case SECTION_CREATE:
                System.out.println("Good code is its own best documentation. As you're about to add a comment, ask yourself, 'How can I improve the code so that this comment isn't needed?'" + "- Steve McConnell");
                break;
            case RETURN:
                existingUserMenu.init();
                break;
            case EXIT:
                System.exit(0);
            default:
                flushConsole();
                throw new InvalidUserInputException();

        }
    }

    private void doIfBasicUser() {
        if (abstractUserController instanceof BasicUserController) {
            try {
                flushConsole();

                Scanner in = new Scanner(System.in);

                basicUserSelectionDialogue();

                int option = in.nextInt();

                basicUserSelectionMenu(option);

            } catch (InvalidUserInputException e) {
                printLn("Error: " + e.getMessage());
                init();
            }
        }
    }

    private void doIfAuthor() {
        if (abstractUserController instanceof AuthorController) {
            try {
                flushConsole();

                Scanner in = new Scanner(System.in);

                authorSelectionDialogue();

                int option = in.nextInt();

                authorSelectMenu(option);

            } catch (InvalidUserInputException e) {
                printLn("Error: " + e.getMessage());
                init();
            }
        }
    }
}
