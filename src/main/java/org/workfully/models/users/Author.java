package org.workfully.models.users;

import java.util.ArrayList;

import org.workfully.models.content.AbstractContent;

public class Author extends AbstractUser {

    private ArrayList<AbstractContent> contentLog;

    public Author() {
        this.contentLog = new ArrayList<>();
    }

    public Author(String userName) {
        super(userName);
        this.contentLog = new ArrayList<>();
    }

    public ArrayList<AbstractContent> getContentLog() {
        return contentLog;
    }

}
