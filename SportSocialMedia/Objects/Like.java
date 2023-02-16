package SportSocialMedia.Objects;

public class Like {
    protected String date;
    protected User user;
    
    public Like(String date, User user) {
        this.date = date;
        this.user = user;
    }
    public String getDate() {
        return date;
    }
    public User getUser() {
        return user;
    }

    
    
}
