package org.workfully.users.utilities.StrategyDP;

import static org.workfully.users.utilities.StringFactory.*;

import java.util.logging.Logger;

public class ValidateUserInput {

    private static Logger log = Logger.getGlobal();

    public static String isValidMessage(String message) {
        if (message == null)
            message = emptyString;
        // Temporary Validation TODO Validate on User Input
        if (message.length() > 280){
            log.warning(toManyCharacters);
            message = toManyCharacters;
        }
        return message;
    }
}
