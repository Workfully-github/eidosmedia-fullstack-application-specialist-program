package Projects.Sports_Social_News.models.interactions;

import Projects.Sports_Social_News.models.users.User;

public class Comment extends Interaction {
    
    private String comment;

    public Comment(User user, String comment) {
        super(user);
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
