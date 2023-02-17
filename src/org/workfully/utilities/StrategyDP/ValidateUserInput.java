package org.workfully.utilities.StrategyDP;

import static org.workfully.factories.StringFactory.*;

import java.util.logging.Logger;

import org.workfully.models.content.AbstractContent;

public class ValidateUserInput {

    private static Logger log = Logger.getGlobal();

    public static String isValidMessage(String message) {
        if (message == null)
            message = emptyString;

        return message;
    }

    public static void presentTweet(AbstractContent abstractContent) {
        if (abstractContent.getTextBody().length() < 280) {
            System.out.println("Tweet: " + abstractContent.getTextBody());
            return;
        }

        log.warning(toManyCharacters);
    }

    public static void presentTextPost(AbstractContent abstractContent) {
        System.out.println(abstractContent.getClass().getTypeName() + ": " + abstractContent.getTextBody());
    }
}
