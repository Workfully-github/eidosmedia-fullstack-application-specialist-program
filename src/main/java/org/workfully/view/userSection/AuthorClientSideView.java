package org.workfully.view.userSection;

import java.util.logging.Logger;

import org.workfully.controllers.users.AuthorController;
import org.workfully.models.content.AbstractContent;
import org.workfully.utilities.Bootstrap;
import org.workfully.utilities.facadeDP.InputDialoguesUtils;
import org.workfully.view.section.HomeFeed;

public class AuthorClientSideView extends AbstractClientSideView {

    /* CONSTRUCTOR */
    public AuthorClientSideView(AuthorController userController) {
        this.userController = userController;
        this.log = Logger.getLogger(AuthorClientSideView.class.getName());
    }

    /* METHODS */
    public void writeTweetDialogue() {
        InputDialoguesUtils.writeTweet(((AuthorController) userController), log);
    }

    public void writePostArticle() {
        InputDialoguesUtils.writePostDialogue(((AuthorController) userController), log);
    }

    public void writeImageGallery() {
        InputDialoguesUtils.writeImageGalleryDialogue(((AuthorController) userController), log);
    }

    public void writeVideoPost() {
        InputDialoguesUtils.writeVideoPostDialogue(((AuthorController) userController), log);
    }

    public void showAuthorSection() {
        ((AuthorController) userController).getAuthorSectionView().displayView();
    }

    @Override
    public void showHomeFeed() {
        HomeFeed homeFeed = new HomeFeed();
        homeFeed.setGlobalMap(Bootstrap.getGlobalContentMapController().getGlobalMap());
        homeFeed.showHomeFeed();
    }

    @Override
    public void read(AbstractContent content) {
        content.getPostDetail().showPostDetail();
    }
}
