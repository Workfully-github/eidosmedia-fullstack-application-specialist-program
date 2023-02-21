package View.NavigationViews;

import java.util.Scanner;

import Controller.Utils.Printer;
import Model.Users.Author;
import View.CreateContentViews.CreateImageGalleryView;
import View.CreateContentViews.CreateTweetView;

public class CreateView  {
    
    public static void show(Author author){
        Printer.printMultiLines("What type of content would you like to create today?:\n", "[1] -- Tweet", "[2] -- Text", "[3] -- Image Gallery" ,"[4] -- Video\n");
        Scanner in = new Scanner(System.in);
        int userInput = in.nextInt();
        switch (userInput) {
            case 1:
                new CreateTweetView().createContentDialog(author);
                break;
            case 2:
                new CreateTweetView().createContentDialog(author);;
                break;
            case 3:
                new CreateImageGalleryView().createContentDialog(author);;
                break;
            case 4:
                new CreateTweetView().createContentDialog(author);
                break;
        
            default:
                break;
        }
    }
}
