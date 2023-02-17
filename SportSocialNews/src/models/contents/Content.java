package models.contents;

import models.users.AuthorUser;
import models.interactions.Comment;
import models.interactions.Reaction;

import java.util.ArrayList;

public abstract class Content {
    protected AuthorUser authorUser;
    protected ArrayList<Comment> comments;
    protected ArrayList<Reaction> reactions;
    protected String title;


    public Content(AuthorUser authorUser, String title) {
        this.authorUser = authorUser;
        this.title = title;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public ArrayList<Reaction> getReactions() {
        return reactions;
    }

    public String getTitle() {
        return title;
    }

    public AuthorUser getAuthorUser() {
        return authorUser;
    }

    public void setAuthorUser(AuthorUser authorUser) {
        this.authorUser = authorUser;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public void setReactions(ArrayList<Reaction> reactions) {
        this.reactions = reactions;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
