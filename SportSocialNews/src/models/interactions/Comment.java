package models.interactions;

import models.users.User;

public class Comment extends Interaction {
    private String body;

    public Comment(User author, String body) {
       super(author);
       this.body = body;
    }
}
