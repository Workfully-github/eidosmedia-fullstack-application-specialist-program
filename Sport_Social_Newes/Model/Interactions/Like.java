package Model.Interactions;

import java.util.ArrayList;

import Model.Content.Content;
import Model.Users.User;


public class Like {
    private User user;
    private Content content;     
    public Like(User user, Content content) {
        this.user = user;
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public Content getContent() {
        return content;
    }

}
