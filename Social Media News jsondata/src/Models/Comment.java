package Models;

import Models.Abstract.User;

public class Comment {
    protected String text;
    protected User user;
    protected String date = "today";

    
    public Comment(String text, User user, String date) {
        this.text = text;
        this.user = user;
        this.date = date;
    }
    public Comment(String text, User user) {
        this.text = text;
        this.user = user;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public User getUser() {
        return user;
    }
    public String getDate() {
        return date;
    }
    @Override
    public String toString() {
        return "##" + text + ", By=" + user + ", date=" + date + "\n";
    }
    
    
}
