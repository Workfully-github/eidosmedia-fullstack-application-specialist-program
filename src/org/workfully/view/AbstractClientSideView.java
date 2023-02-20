package org.workfully.view;

import java.util.Scanner;
import java.util.logging.Logger;

import org.workfully.Bootstrap;
import org.workfully.controllers.users.AbstractUserController;
import org.workfully.models.content.AbstractContent;
import org.workfully.view.section.HomeFeed;

public abstract class AbstractClientSideView {

    /* PROPERTIES */
    protected AbstractUserController userController;
    protected Logger log;


    /* METHODS */
    
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

    public void showFreeHomeFeed(){
        HomeFeed homeFeed = new HomeFeed();
        homeFeed.setGlobalMap(Bootstrap.getGlobalContentMapController().getGlobalMap());

        homeFeed.showFreeHomeFeed();
    }

    
    // TODO this needs to be finished
    public void writeComment(AbstractContent content){
        Scanner scMessage = new Scanner(System.in);
        try {
            System.out.print("Write Comment: ");
            String comment = scMessage.nextLine();

            userController.comment(comment, content);
        } catch (Exception e) {
            log.warning(e.getMessage());
        }
    }
    
}
