package org.workfully.utilities.exceptions;

public class InvalidUserInputException extends Exception{

    public InvalidUserInputException(String message) {
        super(message);
    }

    public InvalidUserInputException() {
        super("Invalid User Input");
    }
}
