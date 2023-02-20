package Projects.Sports_Social_News.models.interactions;

import Projects.Sports_Social_News.models.users.User;

public class Interaction {
    
    private User user;

    public Interaction(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
