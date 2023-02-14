package Football_Match;
import java.util.*;

public class tryInput {
    
    public static void main(String[] args) {
       /*  Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number- ");  
        int a= sc.nextInt();  
        System.out.print("Enter second number- ");  
        int b= sc.nextInt();  
        System.out.print("Enter third number- ");  
        int c= sc.nextInt();  
        int d=a+b+c;  
        System.out.println("Total= " +d);  */ 
        String scorer = enterScorer();
        int minute = enterMinute();
        String assistant = enterAssistant();

        System.out.println("There was a goal scored by " + scorer + " assisted by " + assistant + " at minute " + minute);
    }
    public static String enterScorer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the scorer of the goal - ");  
        String scorer = sc.nextLine();  
        return scorer; 
    }
    public static int enterMinute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the minute of the goal - ");  
        int minute = sc.nextInt();
        return minute;
    }
    public static String enterAssistant() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the assistant - ");  
        String assistant = sc.nextLine();
        return assistant;
    }


}
