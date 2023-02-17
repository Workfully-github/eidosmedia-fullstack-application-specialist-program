package models.interactions;

import models.users.User;

public class Reaction extends Interaction {
    private boolean like;
    public Reaction(User author,boolean like) {
        super(author);
        this.like = like;
    }

    public boolean isLike() {
        return like;
    }


}
