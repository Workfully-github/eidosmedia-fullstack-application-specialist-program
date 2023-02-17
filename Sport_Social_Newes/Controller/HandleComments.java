package Controller;

import Model.Content;
import Model.User;
import Model.Interactions.Comment;

public class HandleComments {
    public Boolean postAComment(Content content, User user, String commentBody) throws NullPointerException {
        //Exceptions Handling
        if(commentBody.isEmpty()) return null;

        Comment newComment = new Comment(user, commentBody);
        content.addComment(newComment);
        
        return true;
    }
}
