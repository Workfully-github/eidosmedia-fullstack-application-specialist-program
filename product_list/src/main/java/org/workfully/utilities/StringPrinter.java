package org.workfully.utilities;

public class StringPrinter {

    public static void print(String message) {
        System.out.print(message);
    }

    public static void printLn(String message) {
        System.out.println(message);
    }

    public static void printMultiLn(String... text) {
        for (String sentence : text) {
            System.out.println(sentence);
        }
    }

    public static void flushConsole() {
        printLn("\033[H\033[2J");
    }
}
