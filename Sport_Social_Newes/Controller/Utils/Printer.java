package Controller.Utils;

public class Printer {
    public static void printMultiLines(String ... strings){
        for(String string : strings){
            System.out.println(string);
        }
    }
 

    public static void devider(){
        System.out.println("------------------------------------------");
    }
}
