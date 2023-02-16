package org.workfully.content;

import org.workfully.users.Author;

public abstract class AbstractContent {

    /* PROPERTIES */
    private Author contentAuthor;
    private String textBody;

    /* GETTERS */
    public Author getContentAuthor() {
        return contentAuthor;
    }
    public String getTextBody() {
        return textBody;
    }
    
}
