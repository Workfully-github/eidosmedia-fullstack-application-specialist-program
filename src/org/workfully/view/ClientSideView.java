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
    public ClientSideView() {
        this.bootstrap = new Bootstrap();
        this.authorController = bootstrap.getAuthorController(1);

        this.log = Logger.getLogger(ClientSideView.class.getName());
    }

    /* GETTERS */
    //FIXME Just for tests
    public AuthorController getAuthorController() {
        return authorController;
    }
    

    public Bootstrap getBootstrap() {
        return bootstrap;
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

    public void showHomeFeed(){
        HomeFeed homeFeed = new HomeFeed();
        homeFeed.setGlobalMap(bootstrap.getGlobalContentMapController().getGlobalMap());

        homeFeed.showHomeFeed();
    }
}
