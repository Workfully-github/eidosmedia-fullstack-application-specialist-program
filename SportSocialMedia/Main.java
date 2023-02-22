package SportSocialMedia;

import java.util.ArrayList;
import java.util.List;

import SportSocialMedia.Controller.TweetPostController;
import SportSocialMedia.Models.Content.ImagePost;
import SportSocialMedia.Models.Content.TextPost;
import SportSocialMedia.Models.Content.TweetPost;
import SportSocialMedia.Models.Content.VideoPost;
import SportSocialMedia.Models.User.Author;
import SportSocialMedia.Models.User.BasicUser;
import SportSocialMedia.Models.User.PremuimUser;
import SportSocialMedia.View.InitPost;
import SportSocialMedia.View.InitUser;

public class Main {
    

    public static void main(String[] args) {
        // Declare Users
        Author author1 = (Author) InitUser.createAuthor();
        Author author2 =(Author)  InitUser.createAuthor();
        BasicUser userBasic = (BasicUser) InitUser.createUser(false);
        PremuimUser premiumBasic = (PremuimUser) InitUser.createUser(true);

        // Declare Contents
        List<TweetPost> tweetPostsList = new ArrayList<>();
        List<VideoPost> videoPostsList = new ArrayList();
        List<TextPost> textPostsList = new ArrayList<>();
        List<ImagePost> imagePostsList = new ArrayList<>();

        // Create some example posts
        TweetPost tweetPost1 = InitPost.createTweetPost(author1);
        TweetPost tweetPost2 = InitPost.createTweetPost(author1);
        TweetPost tweetPost3 = InitPost.createTweetPost(author2);

        tweetPost3.like(author1);
        tweetPost3.comment(author1,"best post of the year");

        tweetPostsList.add(tweetPost1);
        tweetPostsList.add(tweetPost2);
        tweetPostsList.add(tweetPost3);

        // Display all tweet posts
        System.out.println(":::::All Tweet Posts:\n");
        TweetPostController.displayAll(tweetPostsList);

        // Display author section
        System.out.println(":::::Author Section with his posts:\n");
        TweetPostController.displayAuthorSection(author1, tweetPostsList);

        // Display user tweet posts
        System.out.println(":::::User Tweet Posts:\n");
        TweetPostController.userShowTweetPost(userBasic, tweetPostsList);
    }
}
