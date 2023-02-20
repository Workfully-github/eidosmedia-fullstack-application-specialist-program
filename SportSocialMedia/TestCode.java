package SportSocialMedia;

import SportSocialMedia.Controller.TweetPostController;
import SportSocialMedia.Models.Content.TweetPost;
import SportSocialMedia.Models.User.Author;
import SportSocialMedia.Models.User.BasicUser;
import SportSocialMedia.Models.User.PremuimUser;
import SportSocialMedia.View.InitUser;

public class TestCode {
    public static void main(String[] args) {
        //declare Users
        Author author1 =InitUser.createAuthor();
        BasicUser userBasic = new BasicUser("patrick","2");
        PremuimUser premuimBasic = new PremuimUser("patrick","2");

        //Declare Contents
        TweetPost tweetPost = new TweetPost("tweet for today", author1);
        tweetPost.updateTweetPost("we just receive 100 dollars order from our platform");
        TweetPostController.displayTweet(tweetPost);
    }
    
}
