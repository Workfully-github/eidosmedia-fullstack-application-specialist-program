package View.NavigationViews;

import java.util.ArrayList;
import java.util.Scanner;

import javax.security.auth.login.AppConfigurationEntry;

import Controller.ContentControllers.CreateContentController;
import Controller.FeedControllers.FeedController;
import Controller.Home.Start;
import Controller.UsersControllers.AuthorController;
import Controller.Utils.Printer;
import Model.Content.Content;
import Model.Content.Tweet;
import Model.Users.Author;
import View.AppStarter;

public class AuthorView extends UserView{

    @Override
    public void show(){
        Printer.printMultiLines("Would you like to:\n", "[1] -- Read Content", "[2] -- Create Content", "[3] -- Go to Profile", "[4] -- Go Back to home page\n");
        Author newAuthor = new Author("visiter", "visiterUN", "visiter@ssn.net", true); 
        Tweet newTweet = new Tweet(newAuthor, "I spent too mutch time on this", false);
        CreateContentController.pushContent(newTweet);
        ArrayList<Content> storedContent = new ArrayList<Content>();
        storedContent.add(newTweet);
        FeedController.createFeedPage(storedContent);
        // AuthorController authorController = new AuthorController();

        Scanner in = new Scanner(System.in);
        int userInput = in.nextInt();

        switch (userInput) {
            case 1:
                FeedView.show(newAuthor);
                break;
            case 2:
                CreateView.show(newAuthor);
                break;
            case 3:

                FeedView.showProfile(newAuthor);
                break;

            case 4:
                AppStarter.takeOff();
            break;
        
            default:
                break;
        }
    }
}
