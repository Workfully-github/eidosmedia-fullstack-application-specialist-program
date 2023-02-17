package org.workfully.utilities.strategyDP;


import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.workfully.models.content.TextPost;
import org.workfully.models.content.Tweet;
import org.workfully.utilities.exceptions.InvalidUserInputException;

public class ValidateUserInput {

    /* PROPERTIES */


    /* METHODS */
    public static String validateMessage(String message) throws Exception {
        return checkIfEmptyOrNull(message);
    }

    public static String validateURL(String message) throws Exception {
        checkIfEmptyOrNull(message);
        if (isValidURL(message)) {
            return message;
        }

        throw new InvalidUserInputException("Invalid URL");
    }

    private static boolean isValidURL(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException e) {
            return false;
        } catch (URISyntaxException e) {
            return false;
        }
    }

    public static String validateTweet(String message) throws Exception {
        checkIfEmptyOrNull(message);
        if (message.length() > 280)
            throw new InvalidUserInputException();

        return message;
    }

    private static String checkIfEmptyOrNull(String message) throws Exception {
        if (message == null)
            throw new NullPointerException("This input is null");

        if (message.isEmpty())
            throw new InvalidUserInputException("This input is empty");

        return message;
    }

    // TODO move to different strategy Class
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
