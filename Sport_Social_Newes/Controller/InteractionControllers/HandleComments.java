package Controller.InteractionControllers;

import java.util.ArrayList;

import Model.Content.Content;
import Model.Interactions.Comment;
import Model.Users.User;

public class HandleComments {
    public Boolean postAComment(Content content, User user, String commentBody) throws NullPointerException {
        //Exceptions Handling
        if(commentBody.isEmpty()) return null;

        Comment newComment = new Comment(user, commentBody);
        content.addComment(newComment);
        
        return true;
    }

    public void displayComments(Content content){
        for(Comment comment : content.getComments()){
            System.out.println(comment.getCommentBody() + " By: " + comment.getCommenter().getUserName());
        }
    }
}
