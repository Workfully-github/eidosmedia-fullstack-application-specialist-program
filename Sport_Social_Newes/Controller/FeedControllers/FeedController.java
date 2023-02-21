package Controller.FeedControllers;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.ContentControllers.CreateImagePostController;
import Controller.ContentControllers.CreateTextPostController;
import Controller.ContentControllers.CreateTweetsController;
import Controller.ContentControllers.CreateVideoPostController;
import Controller.Utils.Printer;
import Model.Feed;
import Model.Content.Content;
import Model.Users.User;

public class FeedController {
    
    public static void createFeedPage(ArrayList<Content> storedContent){
            Feed.setFeed(storedContent);
            
    }
    
    public static void displayFeedContent(ArrayList<Content> allContent , User user) {
            Printer.devider();
            for(int i = 0; i < allContent.size(); i++){
                switch (allContent.get(i).getClass().toString()) {
                    case "class Model.Content.Tweet":
                         new CreateTweetsController().display(allContent.get(i), user, true, i);
                        break;
    
                    case "class Model.Content.Text":
                        new CreateTextPostController().display(allContent.get(i), user, true, i);
                        break;
                        case "class Model.Content.Video":
                        new CreateVideoPostController().display(allContent.get(i), user, true, i);
                        break;
                    case "class Model.Content.ImageGallery":
                        new CreateImagePostController().display(allContent.get(i), user, true, i);
                        break;
                    
                    default:
                        break;
                }
            
            }
            Printer.printMultiLines("You can read a post by entering the post index: ");
            Scanner in = new Scanner(System.in);
            int userInput = in.nextInt(); 

            switch (allContent.get(userInput).getClass().toString()) {
                case "class Model.Content.Tweet":
                     new CreateTweetsController().display(allContent.get(userInput), user, false, 0);
                    break;

                case "class Model.Content.Text":
                    new CreateTextPostController().display(allContent.get(userInput), user, false, 0);
                    break;
                    case "class Model.Content.Video":
                    new CreateVideoPostController().display(allContent.get(userInput), user, false, 0);
                    break;
                case "class Model.Content.ImageGallery":
                    new CreateImagePostController().display(allContent.get(userInput), user, false, 0);
                    break;
                
                default:
                    break;
            }
    
    }


}
