package org.workfully.content;

import java.util.ArrayList;

import org.workfully.reactions.AbstractReaction;
import org.workfully.users.Author;

public abstract class AbstractContent {

    /* PROPERTIES */
    private Author contentAuthor;
    private String textBody;
    private ArrayList<UserComment> commentLogMap;
    private ArrayList<AbstractReaction> reactionLogMap;

    /* GETTERS */
    public Author getContentAuthor() {
        return contentAuthor;
    }

    public String getTextBody() {
        return textBody;
    }

    public ArrayList<UserComment> getCommentLogMap() {
        return commentLogMap;
    }

    public ArrayList<AbstractReaction> getReactionLogMap() {
        return reactionLogMap;
    }

}
