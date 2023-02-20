package SportSocialMedia;

import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import SportSocialMedia.Controller.TweetPostController;
import SportSocialMedia.Models.Content.ImagePost;
import SportSocialMedia.Models.Content.TextPost;
import SportSocialMedia.Models.Content.TweetPost;
import SportSocialMedia.Models.Content.VideoPost;
import SportSocialMedia.Models.User.Author;
import SportSocialMedia.Models.User.BasicUser;
import SportSocialMedia.Models.User.PremuimUser;
import SportSocialMedia.View.InitUser;

public class TestCode {
    public static void main(String[] args) {
        //declare Users
        Author author1 =InitUser.createAuthor();
        Author author2 =new Author("Bob", (InitUser.id++)+"");
        BasicUser userBasic = new BasicUser("patrick",(InitUser.id++)+"");
        PremuimUser premuimBasic = new PremuimUser("patrick",(InitUser.id++)+"");

        //Declare Contents

        List<TweetPost> tweetPostsList = new ArrayList();
        List<VideoPost> videoPostsList = new ArrayList();
        List<TextPost> textPostsList = new ArrayList();
        List<ImagePost> imagePostsList = new ArrayList();

        TweetPost tweetPost1 = new TweetPost("tweet for today", author1);
        tweetPost1.updateTweetPostText("we just receive 100 dollars order from our platform");
        TweetPost tweetPost2 = new TweetPost("My Second Post", author1);
        tweetPost2.updateTweetPostText("Goodbye World!");
        TweetPost tweetPost3 = new TweetPost("a other Post", author2);
        tweetPost3.updateTweetPostText("Hello World!");
        TweetPostController.displayTweet(tweetPost1);

        tweetPostsList.add(tweetPost1);
        tweetPostsList.add(tweetPost2);
        tweetPostsList.add(tweetPost3);

        TweetPostController.displayAll(tweetPostsList);

        TweetPostController.displayAuthorSection(author1, tweetPostsList);

    }
    
}
