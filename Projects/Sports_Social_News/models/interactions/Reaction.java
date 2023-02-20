package Projects.Sports_Social_News.models.interactions;

import Projects.Sports_Social_News.models.users.User;

public class Reaction extends Interaction {
    
    private boolean like;
    
    public Reaction(User user, boolean like) {
        super(user);
        this.like = like;
    }

    public boolean isLike() {
        return like;
    }

    // this turns the boolean to the oposite value so that when we can dislike something
    public void setLike(boolean like) {
        this.like = !like;
    }
}
