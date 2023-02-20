package Model.Interactions;

import Model.Content.Content;
import Model.Users.User;

public class Save {
    private User user;
    private Content content;
     
    public Save(User user, Content content) {
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
