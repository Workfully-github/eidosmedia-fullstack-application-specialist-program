package org.workfully.view;

import static org.workfully.utilities.factories.StringFactory.*;

import java.util.Scanner;
import java.util.logging.Logger;

import org.workfully.Bootstrap;
import org.workfully.controllers.users.AuthorController;
import org.workfully.models.content.AbstractContent;
import org.workfully.view.section.HomeFeed;

public class ClientSideView {

    /* PROPERTIES */
    private Bootstrap bootstrap;
    private AuthorController authorController; // FOR TESTS PURPOSES
    private Logger log;

    /* CONSTRUCTOR */
    public ClientSideView(AuthorController authorController) {
        this.bootstrap = new Bootstrap();
        this.authorController = authorController;
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

    // TODO this needs to be finished
    public void writeComment(AbstractContent content){
        Scanner scMessage = new Scanner(System.in);
        try {
            System.out.print("Write Comment: ");
            String comment = scMessage.nextLine();

            authorController.comment(comment, content);
        } catch (Exception e) {
            log.warning(e.getMessage());
        }
    }

    public void showAuthorSection() {
        authorController.getAuthorSectionView().displayView();
    }

    /* 
     * When HomeFeed() is called, 
     * Sets HomeFeed's global map with the existing global map
     * and then shows the feed fully updated
     */
    public void showHomeFeed(){
        HomeFeed homeFeed = new HomeFeed();
        homeFeed.setGlobalMap(Bootstrap.getGlobalContentMapController().getGlobalMap());

        homeFeed.showHomeFeed();
    }
}
