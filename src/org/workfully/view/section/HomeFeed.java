package org.workfully.view.section;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.workfully.models.content.AbstractContent;
import org.workfully.models.content.TextPost;
import org.workfully.models.content.Tweet;
import org.workfully.models.users.AbstractUser;
import org.workfully.utilities.facadeDP.ValidateUserInput;
import static org.workfully.utilities.factories.StringFactory.*;

public class HomeFeed extends AbstractSection {

    /* PROPERTIES */
    private HashMap<AbstractUser, ArrayList<AbstractContent>> globalMap;

    /* METHODS */
    public void showHomeFeed(){

        System.out.println(homeFeedHeader +"\n");

        for (Map.Entry<AbstractUser, ArrayList<AbstractContent>> author : globalMap.entrySet()) {
                
            for (AbstractContent content : author.getValue()) {
                if(content instanceof TextPost){
                   TextPost textPost = TextPost.class.cast(content);
                   System.out.println("Created by: " + textPost.getAuthorName()); 
                   ValidateUserInput.presentTextPost(textPost);
                }

                if(content instanceof Tweet){
                    Tweet tweet = Tweet.class.cast(content);
                    System.out.println("Created by: " + tweet.getAuthorName()); 
                    ValidateUserInput.presentTweet(tweet);
                 }
            }
        }
    }

    
    /* SETTERS */
    public void setGlobalMap(HashMap<AbstractUser, ArrayList<AbstractContent>> globalMap) {
        this.globalMap = globalMap;
    }
    
    
    
}
