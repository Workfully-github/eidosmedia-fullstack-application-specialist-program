package org.workfully.utilities;

public class StringPrinter {

    public static void print(String message) {
        System.out.print(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printMultiLn(String... text) {
        for (String sentence : text) {
            System.out.println(sentence);
        }
    }

    public static void flushConsole() {
        println("\033[H\033[2J");
    }
}
