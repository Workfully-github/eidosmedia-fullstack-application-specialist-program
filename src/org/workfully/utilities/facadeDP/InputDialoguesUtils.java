package org.workfully.utilities.facadeDP;

import java.util.Scanner;
import java.util.logging.Logger;
import org.workfully.controllers.users.AuthorController;
import static org.workfully.utilities.factories.StringFactory.*;

public class InputDialoguesUtils {

    public static void writePostDialogue(AuthorController userController, Logger log) {
        Scanner scMessage = new Scanner(System.in);
        try {
            printLn("Insert Cover Image URL: ");
            String URL = scMessage.nextLine();

            printLn("Write Post Article: ");
            String message = scMessage.nextLine();

            printMultiLn(dialogueSelectionFreeOrPremium);
                   
            int selection = scMessage.nextInt();

            switch (selection) {
                case FREE_SELECTION:
                    userController.createTextPost(message, URL, false);
                    break;
                case PREMIUM_SELECTION:
                    userController.createTextPost(message, URL, true);
                    break;
                case default: 
                    log.info(inputLogInfo);
                    break;
            }

        } catch (Exception e) {
            log.warning(e.getMessage());
        }
    }

}
