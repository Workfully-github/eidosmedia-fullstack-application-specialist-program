package View.InteractinsView;

import java.util.Scanner;

import Controller.ContentControllers.CreateTweetsController;
import Controller.InteractionControllers.HandleComments;
import Controller.InteractionControllers.HandleLikes;
import Controller.InteractionControllers.HandleSaves;
import Controller.Utils.HandleAuth;
import Model.Content.Content;
import Model.Users.User;
import View.HandleCommentView;

public class CreateInteractionsView {
    public void displayInteractionOptions(Content content, User user) {
        HandleAuth handleAuth = new HandleAuth();
        if(!handleAuth.checkUserContentRelationship(user, content)) {
            System.out.println("You can not Interact with a premium content as a basic user");
            return;
        }
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
            handleLikes.like(content, user);
        }

        if (option == 1) {
            handleSaves.save(content, user);
        }
        
        if(option == 2) {
            handleCommentView.creatCommentView(content, user);
        }
        
        createTweetsController.display(content, user, false, 0);
      
    }
}
