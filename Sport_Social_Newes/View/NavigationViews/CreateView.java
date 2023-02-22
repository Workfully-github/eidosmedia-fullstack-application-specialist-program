package View.NavigationViews;

import java.util.Scanner;

import Controller.ContentControllers.CreateTextPostController;
import Controller.Utils.Printer;
import Model.Users.Author;
import View.CreateContentViews.CreateImageGalleryView;
import View.CreateContentViews.CreateTextView;
import View.CreateContentViews.CreateTweetView;
import View.CreateContentViews.CreateVideoView;

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
                new CreateTextView().createContentDialog(author);;
                break;
            case 3:
                new CreateImageGalleryView().createContentDialog(author);;
                break;
            case 4:
                new CreateVideoView().createContentDialog(author);
                break;
        
            default:
                break;
        }
    }
}
