
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import Controller.TweetPostController;
import Models.Content.ImagePost;
import Models.Content.TextPost;
import Models.Content.TweetPost;
import Models.Content.VideoPost;
import Models.User.Author;
import Models.User.BasicUser;
import Models.User.PremuimUser;
import View.InitUser;

public class TestCode {
    public static void main(String[] args) {
        //declare Users
        Author author1 =InitUser.createAuthor();
        Author author2 =new Author("Bob", (InitUser.id++)+"", true);
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
        TweetPost tweetPost3 = new TweetPost("a other Post", author2, true);
        tweetPost3.updateTweetPostText("Hello World!");
        tweetPost3.like(author1);
        tweetPost3.comment(author1,"best post of the year");

        tweetPostsList.add(tweetPost1);
        tweetPostsList.add(tweetPost2);
        tweetPostsList.add(tweetPost3);

        TweetPostController.displayAll(tweetPostsList);

        TweetPostController.displayAuthorSection(author1, tweetPostsList);

        TweetPostController.userShowTweetPost(author1, tweetPostsList);

        // TweetPostController.displayTweet(tweetPost3);

    }
    
}
