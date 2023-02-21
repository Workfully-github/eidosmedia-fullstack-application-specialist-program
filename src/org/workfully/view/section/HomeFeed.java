package org.workfully.view.section;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.workfully.Bootstrap;
import org.workfully.models.content.AbstractContent;
import org.workfully.models.content.UserComment;
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

   
    public void showFreeHomeFeed() {

        
        System.out.println(homeFeedHeader + "\n");


        for (Map.Entry<AbstractUser, ArrayList<AbstractContent>> author : globalMap.entrySet()) {
            //System.out.println(globalMap.get(author.getKey()).get(0).getCommentLogMap());
            for (AbstractContent content : author.getValue()) {
                
                System.out.println("Created by: " + content.getAuthorName());
                
                content.getPostDetail().showPostDetailFree();

                //TODO present COMMENTS
                    
        
                
                
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