package org.workfully.section;

import java.util.ArrayList;

import org.workfully.content.AbstractContent;
import org.workfully.users.Author;

public class AuthorSection extends AbstractSection {

    /* PROPERTIES */
    private Author sectionOwner;
    private ArrayList<AbstractContent> contentCreatedLogMap;

    /* GETTERS */
    public Author getSectionOwner() {
        return sectionOwner;
    }

    public ArrayList<AbstractContent> getContentCreatedLogMap() {
        return contentCreatedLogMap;
    }

    

}
