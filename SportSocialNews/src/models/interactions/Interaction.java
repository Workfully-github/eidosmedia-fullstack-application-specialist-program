package models.interactions;

import models.users.User;

public abstract class Interaction{
    private User author;

    public Interaction(User author) {
        this.author = author;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
