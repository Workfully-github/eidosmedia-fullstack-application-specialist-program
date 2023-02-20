package Model.Interactions;

import Model.Users.User;

public class Comment {
    User commenter;
    String commentBody;

     public Comment(User commenter, String commentBody) {
        this.commenter = commenter;
        this.commentBody = commentBody;
     }

     public String getCommentBody() {
         return commentBody;
     }

     public User getCommenter() {
         return commenter;
     }

}
