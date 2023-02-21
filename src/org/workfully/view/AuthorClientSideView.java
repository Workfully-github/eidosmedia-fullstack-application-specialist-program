package org.workfully.view;


import java.util.Scanner;
import java.util.logging.Logger;

import org.workfully.Bootstrap;
import org.workfully.controllers.users.AuthorController;
import org.workfully.utilities.facadeDP.InputDialoguesUtils;
import org.workfully.view.section.HomeFeed;

public class AuthorClientSideView extends AbstractClientSideView {

    /* CONSTRUCTOR */
    public AuthorClientSideView(AuthorController userController) {
        this.userController = userController;
        this.log = Logger.getLogger(AuthorClientSideView.class.getName());
    }

    /* METHODS */
    public void writeTweet() {
        Scanner scCreateTweet = new Scanner(System.in);
        try {
            System.out.print("Write your Tweet: ");
            String scanInput = scCreateTweet.nextLine();
            ((AuthorController) userController).createTweet(scanInput);
        } catch (Exception e) {
            log.warning(e.getMessage());
        }
    }

    public void writePostArticle() {
        InputDialoguesUtils.writePostDialogue(((AuthorController)userController), log);
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
}
