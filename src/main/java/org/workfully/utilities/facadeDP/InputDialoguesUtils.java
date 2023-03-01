package org.workfully.utilities.facadeDP;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.workfully.controllers.users.AbstractUserController;
import org.workfully.controllers.users.AuthorController;
import org.workfully.models.content.AbstractContent;
import org.workfully.utilities.factories.StringFactory;

import static org.workfully.utilities.factories.StringFactory.*;

public class InputDialoguesUtils {

    public static void writeTweet(AuthorController userController, Logger log) {
        Scanner scCreateTweet = new Scanner(System.in);
        try {
            System.out.print("Write your Tweet: ");
            String scanInput = scCreateTweet.nextLine();
            userController.createTweet(scanInput);
        } catch (Exception e) {
            log.warning(e.getMessage());
        }
    }

    public static void writeImageGalleryDialogue(AuthorController userController, Logger log) {
        Scanner scMessage = new Scanner(System.in);
        try {
            printLn("Insert Image URL: ");
            String URL = scMessage.nextLine();

            printLn("Write Gallery Description: ");
            String message = scMessage.nextLine();

            userController.createImageGalleryPost(message, URL);
        } catch (Exception e) {
            log.warning(e.getMessage());
        }
    }

    public static void writeVideoPostDialogue(AuthorController userController, Logger log) {
        Scanner scMessage = new Scanner(System.in);
        try {
            printLn("Insert Video URL: ");
            String URL = scMessage.nextLine();

            printLn("Write Video Description: ");
            String message = scMessage.nextLine();

            userController.createVideoPost(message, URL);
        } catch (Exception e) {
            log.warning(e.getMessage());
        }
    }

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
                default:
                    log.info(inputLogInfo);
                    break;
            }

        } catch (Exception e) {
            log.warning(e.getMessage());
        }
    }

    public static void writeComment(AbstractUserController userController, AbstractContent content, Logger log) {
        Scanner scMessage = new Scanner(System.in);
        try {
            System.out.print("Write Comment: ");
            String comment = scMessage.nextLine();

            userController.comment(comment, content);
        } catch (Exception e) {
            log.warning(e.getMessage());
        }
    }
}
