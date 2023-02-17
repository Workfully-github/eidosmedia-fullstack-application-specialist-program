package Model.Interactions;

import Model.User;

public class Comment {
    User commenter;
    String commentBody;

     public Comment(User commenter, String commentBody) {
        this.commenter = commenter;
        this.commentBody = commentBody;
     }

}
