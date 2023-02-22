package org.workfully.utilities.factories;

public class StringFactory {

    public static final String emptyString = "";
    public static final String toManyCharacters = "You have passed the limit of 280 characters.";
    public static final String threeHundredCharacters = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Feugiat scelerisque varius morbi enim nunc faucibus a. Fames ac turpis egestas integer eget aliquet nibh. Sit amet volutpat consequat mauris. Nunc scelerisque viverra mauris in aliquam sem fringilla.";
    public static final String homeFeedHeader = "### HOME FEED ###";
    public static final String inputLogInfo = "You need to select one of the valid options.";
    public static final int PREMIUM_SELECTION = 1;
    public static final int FREE_SELECTION = 2;
    public static final String[] dialogueSelectionFreeOrPremium = {"Is it Free or Premium?", "1 - Free", "2 - Premium"};
    public static final int SECTION_HOME = 0;
    public static final int SECTION_AUTHORS = 1;
    public static final int SECTION_CREATE = 2;
    public static final String NO_CONTENT_AVAILIABLE_AT_INDEX = "The content you are trying to access does not exist. \n";
    public static final String FAVOURITE_HEADER = "### FAVOURITE ###";

    public static void print(String message){
        System.out.print(message);
    }

    public static void printLn(String message){
        System.out.println(message);
    }

    public static void printMultiLn(String ... text){
        for (String sentence : text) {
            System.out.println(sentence);
        }
    }

    public static void flushConsole(){
        printLn("\033[H\033[2J");
    }
}
