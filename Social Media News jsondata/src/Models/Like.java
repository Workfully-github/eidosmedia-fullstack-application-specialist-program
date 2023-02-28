package Models;

import Models.Abstract.User;

public class Like {
    protected String date = "today";
    protected User user;
    
    public Like(String date, User user) {
        this.date = date;
        this.user = user;
    }

    public Like(User user) {
        this.user = user;
    }
    public String getDate() {
        return date;
    }
    public User getUser() {
        return user;
    }

    
    
}
