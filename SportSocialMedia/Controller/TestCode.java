package SportSocialMedia.Controller;

import SportSocialMedia.Objects.Content.TweetPost;
import SportSocialMedia.Objects.User.Author;
import SportSocialMedia.Objects.User.BasicUser;
import SportSocialMedia.Objects.User.PremuimUser;

public class TestCode {
    public static void main(String[] args) {
        //declare Users
        Author author1 = new Author("Habib","1");
        BasicUser userBasic = new BasicUser("patrick","2");
        PremuimUser premuimBasic = new PremuimUser("patrick","2");

        //Declare Contents
        TweetPost tweetPost = new TweetPost("tweet for today", author1);
        tweetPost.updateTweetPost("we just receive 100 dollars order from our platform");
        System.out.println(tweetPost.toString());
    }
    
}
