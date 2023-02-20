package View;

import java.util.Scanner;

import Controller.InteractionControllers.HandleComments;
import Model.Content.Content;
import Model.Users.User;

public class HandleCommentView {
    public void creatCommentView(Content content, User user){
        
        HandleComments handleComments = new HandleComments();
        Scanner in = new Scanner(System.in);
        System.out.println("Insert your comment: ");
        String commentBody = in.nextLine();

        try {
            Boolean isCommentPosted = handleComments.postAComment(content, user, commentBody);
            if(isCommentPosted) System.out.print("Comment posted succssfully");
        } catch (NullPointerException e) {
            System.out.print("Invalide Comment");
        }


    }
}   
