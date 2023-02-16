package org.workfully.content;

import java.util.ArrayList;

import org.workfully.users.Author;

public abstract class AbstractContent {

    /* PROPERTIES */
    private Author contentAuthor;
    private String textBody;
    private ArrayList<UserComment> commentLogMap;

    /* GETTERS */
    public Author getContentAuthor() {
        return contentAuthor;
    }
    public String getTextBody() {
        return textBody;
    }
}
