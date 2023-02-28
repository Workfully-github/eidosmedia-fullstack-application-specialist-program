package org.workfully.controllers.content;

import org.workfully.models.content.Tweet;
import org.workfully.models.users.Author;
import org.workfully.utilities.Bootstrap;
import org.workfully.utilities.facadeDP.ValidateUserInputUtils;

public class TweetController {

    private Tweet tweetModel; // To be used in order to retrieve POJO from DB later

    public TweetController() {
    }

    /*
     * To be used when DB is ready
     */
    public TweetController(Tweet tweetModel) {
        this.tweetModel = tweetModel;
    }

    /*
     * Creates Tweet
     * Saves it in Author Content Log to be used in Author Section
     * Saves it to Global Content Map Controller
     */
    public Tweet createTweet(Author authorModel, String message) throws Exception {
        tweetModel = new Tweet(authorModel, ValidateUserInputUtils.validateTweet(message));
        authorModel.getContentLog().add(tweetModel);
        Bootstrap.getGlobalContentMapController().addAuthorContentToGlobalContentMap(authorModel, tweetModel);
        return tweetModel;
    }
}
