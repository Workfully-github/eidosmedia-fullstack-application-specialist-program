package views;

public class PrintViewUtils {



    public static void print(String message){
        System.out.print(message);
    }

    public static void printLine(String message){
        System.out.println(message);
    }


    public static void printMultiline(String ... messages){
        for (String m: messages) {
            printLine(m);
        }
    }


}
