package org.workfully.view.section;

import static org.workfully.utilities.facadeDP.ValidateUserInput.*;

import java.util.ArrayList;

import org.workfully.controllers.users.AuthorController;
import org.workfully.models.content.AbstractContent;
import org.workfully.models.content.ImageGalleryPost;
import org.workfully.models.content.TextPost;
import org.workfully.models.content.Tweet;
import org.workfully.models.content.VideoPost;

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

    /* BEHAVIOUR */

    public void displayView() {
        
        System.out.println("########## AUTHOR SECTION ##########");
        for (AbstractContent abstractContent : contentCreatedByAuthorLogMap) {
           /*  if (abstractContent instanceof Tweet) {
                presentTweet((Tweet)abstractContent);
            }

            if (abstractContent instanceof TextPost) {
                presentTextPost((TextPost)abstractContent);
            }

            if (abstractContent instanceof ImageGalleryPost) {

            }

            if (abstractContent instanceof VideoPost) {

            } */
            abstractContent.getPostDetail().showPostDetail();
        }
    }

}
