package org.workfully.utilities.facadeDP;

import java.util.Scanner;
import java.util.logging.Logger;
import org.workfully.controllers.users.AuthorController;
import org.workfully.models.content.TextPost;
import static org.workfully.utilities.factories.StringFactory.*;

public class InputDialogues {

    public static void writePostDialogue(AuthorController userController, Logger log) {
        Scanner scMessage = new Scanner(System.in);
        try {
            System.out.print("Insert Cover Image URL: ");
            String URL = scMessage.nextLine();

            System.out.print("Write Post Article: ");
            String message = scMessage.nextLine();

            System.out.println("Is it Free or Premium?");
            System.out.println("1 - Free");
            System.out.println("2 - Premium");
            int selection = scMessage.nextInt();

            switch (selection) {
                case 1:
                    userController.createTextPost(message, URL);
                    break;
                case 2:
                    TextPost text = ((AuthorController) userController).createTextPost(message, URL);
                    text.setPremium();
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
