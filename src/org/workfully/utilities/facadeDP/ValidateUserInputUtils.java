package org.workfully.utilities.facadeDP;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import org.workfully.utilities.exceptions.InvalidUserInputException;

public class ValidateUserInputUtils {

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
}
