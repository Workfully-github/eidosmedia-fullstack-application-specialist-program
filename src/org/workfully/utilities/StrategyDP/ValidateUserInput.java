package org.workfully.utilities.strategyDP;

import static org.workfully.factories.StringFactory.*;

import java.util.logging.Logger;

import org.workfully.models.content.TextPost;
import org.workfully.models.content.Tweet;
import org.workfully.utilities.exceptions.InvalidUserInputException;

public class ValidateUserInput {

    /* PROPERTIES */
    private static Logger log = Logger.getGlobal();

    /* METHODS */
    public static String validateMessage(String message) throws Exception {
        return checkIfEmptyOrNull(message);
    }

    public static String validateTweet(String message) throws Exception {
        checkIfEmptyOrNull(message);
        if (message.length() > 280)
            throw new InvalidUserInputException();

        return message;
    }

    private static String checkIfEmptyOrNull(String message) throws Exception {
        if (message == null)
            throw new NullPointerException();

        if (message.isEmpty())
            throw new InvalidUserInputException();

        return message;
    }

    public static void presentTweet(Tweet tweet) {
            System.out.println("Tweet: " + tweet.getTextBody());
            System.out.print("\n");
    }

    public static void presentTextPost(TextPost textPost) {
        System.out.println("Header: " + textPost.getCoverImgURL());
        System.out.println("Text Post: " + textPost.getTextBody());
        System.out.print("\n");
    }
}
