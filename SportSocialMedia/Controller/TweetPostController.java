package SportSocialMedia.Controller;

import java.util.List;

import SportSocialMedia.Models.Content.TweetPost;
import SportSocialMedia.Models.User.Author;

public class TweetPostController {
    
    public static void displayTweet(TweetPost tweet){
        System.out.println(tweet.toString());
    }

    public static void displayAll(List<TweetPost> tweetList){
        System.out.println("####################Feed Section#####################");
        for (TweetPost post : tweetList) {
            TweetPostController.displayTweet(post);
            System.out.println();
        }
    }

    public static void displayAuthorSection(Author author, List<TweetPost> tweetList){
        System.out.println("####################User Section#####################");
        for (TweetPost post : tweetList) {
            if (post.getAuthor().equals(author)) {
                displayTweet(post);
                System.out.println();
            }
        }
    }
}
