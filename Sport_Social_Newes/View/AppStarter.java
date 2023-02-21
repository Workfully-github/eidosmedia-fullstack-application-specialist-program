package View;

import java.util.Scanner;

import Controller.Home.Start;
import Controller.Utils.Printer;
import View.NavigationViews.AuthorView;
import View.NavigationViews.UserView;

public class AppStarter {
    public static void takeOff(){
        new Start().generateSomeData();
        Scanner in = new Scanner(System.in);

        Printer.printMultiLines("\n\n**WELCOME TO YOUR FAVORITE SPORT NEWS PUBLISHING PLATFORM**\n\n", "Continue As:\n", "[1] -- Auther", "[2] -- Premium User (you will have access to all of our premium content!!)", "[3] -- Basic User\n");
        int userInput = in.nextInt();

        switch (userInput) {
            case 1:
                new AuthorView().show();
                break;
            case 2:
            new UserView().showPremium();
            
                break;
            case 3:
            new UserView().show();
            
                break;
        
            default:
                break;
        }
    }
}
