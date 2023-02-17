package models.users;

import models.interactions.Comment;
import models.interactions.Reaction;
import models.contents.Content;

import java.util.ArrayList;

public abstract class User {
    private String username;

    private ArrayList<Content> favourites;
    private ArrayList<Comment> comments;
    private ArrayList<Reaction> reactions;

    public User(String username) {
        this.username = username;
    }
}
