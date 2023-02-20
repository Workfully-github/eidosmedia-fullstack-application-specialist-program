package org.workfully.view.section;

import java.util.ArrayList;
import org.workfully.controllers.users.AuthorController;
import org.workfully.models.content.AbstractContent;

public class AuthorSection extends AbstractSection {

    /* PROPERTIES */
    private AuthorController authorController;
    private ArrayList<AbstractContent> contentCreatedByAuthorLogMap;

    /* CONSTRUCTOR */
    public AuthorSection(AuthorController authorController) {
        this.authorController = authorController;
        this.contentCreatedByAuthorLogMap = authorController.getContentLog();
    }

    /* GETTERS */

    public ArrayList<AbstractContent> getContentCreatedLogMap() {
        return contentCreatedByAuthorLogMap;
    }

    public AuthorController getSectionOwnerController() {
        return authorController;
    }

    /* METHODS */

    public void displayView() {

        System.out.println("########## " + authorController.getAuthorModel().getUserName() + " : AUTHOR SECTION ########## \n");
        for (AbstractContent abstractContent : contentCreatedByAuthorLogMap) {

            abstractContent.getPostDetail().showPostDetail();
        }
    }

}
