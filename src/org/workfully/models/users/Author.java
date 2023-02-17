package org.workfully.models.users;

import java.util.ArrayList;

import org.workfully.models.content.AbstractContent;

public class Author extends AbstractUser {

    /* PROPERTIES */
    private ArrayList<AbstractContent> contentLog;

    /* CONSTRUCTOR */
    public Author() {
        this.contentLog = new ArrayList<>();
    }

    public Author(String userName) {
        super(userName);
        this.contentLog = new ArrayList<>();
    }

    /* GETTERS */
    public ArrayList<AbstractContent> getContentLog() {
        return contentLog;
    }

    
    
}
