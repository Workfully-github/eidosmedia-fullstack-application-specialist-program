package org.workfully.models.content;

import java.util.ArrayList;

import org.workfully.models.reactions.AbstractReaction;
import org.workfully.models.users.Author;

public abstract class AbstractContent {

    /* PROPERTIES */
    private Author contentAuthor;
    private String textBody;
    private ArrayList<UserComment> commentLogMap;
    private ArrayList<AbstractReaction> reactionLogMap;

    /* CONSTRUCTOR */
    public AbstractContent(Author contentAuthor, String textBody) {
        this.contentAuthor = contentAuthor;
        this.textBody = textBody;
        this.commentLogMap = new ArrayList<>();
        this.reactionLogMap = new ArrayList<>();
    }

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
