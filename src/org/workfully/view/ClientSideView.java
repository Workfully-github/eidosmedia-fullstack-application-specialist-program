package org.workfully.view;

import static org.workfully.utilities.factories.StringFactory.*;

import java.util.Scanner;
import java.util.logging.Logger;

import org.workfully.Bootstrap;
import org.workfully.controllers.users.AuthorController;
import org.workfully.view.section.HomeFeed;

public class ClientSideView {

    /* PROPERTIES */
    private Bootstrap bootstrap;
    private AuthorController authorController;
    private Logger log;

    /* CONSTRUCTOR */
    public ClientSideView() {
        this.bootstrap = new Bootstrap();
        this.authorController = bootstrap.getAuthorController();
        this.log = Logger.getLogger(ClientSideView.class.getName());
    }

    /* METHODS */
    public void writeTweet() {
        Scanner scCreateTweet = new Scanner(System.in);
        try {
            System.out.print("Write your Tweet: ");
            String scanInput = scCreateTweet.nextLine();
            authorController.createTweet(scanInput);
        } catch (Exception e) {
            log.warning(e.getMessage());
        }
    }

    public void writePostArticle() {
        Scanner scMessage = new Scanner(System.in);
        try {
            System.out.print("Insert Cover Image URL: ");
            String URL = scMessage.nextLine();

            System.out.print("Write Post Article: ");
            String message = scMessage.nextLine();

            authorController.createTextPost(message, URL);
        } catch (Exception e) {
            log.warning(e.getMessage());
        }
    }

    public void showAuthorSection() {
        authorController.getAuthorSectionView().displayView();
    }

    public void showHomeFeed(){
        HomeFeed homeFeed = new HomeFeed();
        homeFeed.setGlobalMap(bootstrap.getGlobalContentMapController().getGlobalMap());

        homeFeed.showHomeFeed();
    }
}
