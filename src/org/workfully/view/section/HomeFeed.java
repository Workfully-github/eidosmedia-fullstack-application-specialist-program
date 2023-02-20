package org.workfully.view.section;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.workfully.models.content.AbstractContent;
import org.workfully.models.users.AbstractUser;
import org.workfully.models.users.Author;

import static org.workfully.utilities.factories.StringFactory.*;

public class HomeFeed extends AbstractSection {

    /* PROPERTIES */
    private HashMap<AbstractUser, ArrayList<AbstractContent>> globalMap;

    /* METHODS */

    /*
     * Presents every content, for each author in the Global Map
     */
    public void showHomeFeed() {

        System.out.println(homeFeedHeader + "\n");

        for (Map.Entry<AbstractUser, ArrayList<AbstractContent>> author : globalMap.entrySet()) {

            for (AbstractContent content : author.getValue()) {

                System.out.println("Created by: " + content.getAuthorName());
                content.getPostDetail().showPostDetail();
            }
        }
    }

    //FIXME fix the if condition is printing homefeed twice
    public void showFreeHomeFeed() {

        System.out.println(homeFeedHeader + "\n");


        for (Map.Entry<AbstractUser, ArrayList<AbstractContent>> author : globalMap.entrySet()) {

            for (AbstractContent content : author.getValue()) {
                
                System.out.println("Created by: " + content.getAuthorName());
                
                content.getPostDetail().showPostDetailFree();
                
            }
        }
    }

    /* SETTERS */
    /*
     * @see org.workfully.view.ClientSideView#showHomeFeed()
     */
    public void setGlobalMap(HashMap<AbstractUser, ArrayList<AbstractContent>> globalMap) {
        this.globalMap = globalMap;
    }
}