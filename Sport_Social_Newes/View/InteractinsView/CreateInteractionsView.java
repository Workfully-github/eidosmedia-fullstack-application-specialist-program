package View.InteractinsView;

import java.util.Scanner;

import Controller.ContentControllers.CreateTweetsController;
import Controller.InteractionControllers.HandleComments;
import Controller.InteractionControllers.HandleLikes;
import Controller.InteractionControllers.HandleSaves;
import Controller.InteractionControllers.InteractionController;
import Model.Content.Content;
import Model.Interactions.Like;
import Model.Interactions.Save;
import Model.Users.User;
import View.CreateTweetView;
import View.HandleCommentView;

public class CreateInteractionsView {
    public void displayInteractionOptions(Content content, User user) {

        HandleCommentView handleCommentView = new HandleCommentView();
        CreateTweetsController createTweetsController = new CreateTweetsController();
        
        HandleLikes handleLikes = new HandleLikes();
        HandleSaves handleSaves = new HandleSaves();
        HandleComments handleComments = new HandleComments();

        Scanner in = new Scanner(System.in);
        System.out.println("\n------------------------------");
        System.out.println("[0] --> Like/Dislike");
        System.out.println("[1] --> Save/Unsave");
        System.out.println("[2] --> Post a comment");
        //Work on Return option here
        int option = in.nextInt();
        
        if(option < 0 || option > 2) {System.out.print("\nInvalid option\n"); displayInteractionOptions(content, user); return;};

        if (option == 0) {
            handleLikes.like(new Like(user, content));
        }

        if (option == 1) {
            handleSaves.save(new Save(user, content));
        }
        
        if(option == 2) {
            handleCommentView.creatCommentView(content, user);
        }
        
        createTweetsController.displayTweet(content, user);
      



        // switch (option) {
        //     case 0:
        //         handleLikes.like(new Like(user, content));
        //         break;
            
        //     case 1:
        //     handleSaves.save(new Save(user, content));
        //     break;

        //     case 2:
        //     handleCommentView.creatCommentView(content, user);
        //     displayInteractionOptions(content, user);
        //     break;

        //     case 3:
        //     handleComments.displayComments(content);
        //     break;
            
        //     default:
        //         break;
        // }
    }
}
