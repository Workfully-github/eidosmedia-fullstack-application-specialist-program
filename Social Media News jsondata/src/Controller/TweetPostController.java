package Controller;

import java.util.List;

import Models.Abstract.User;
import Models.Content.TweetPost;
import Models.User.Author;

public class TweetPostController {
    
    public static void displayTweet(TweetPost tweet){
        System.out.println(tweet.toString());
        
    }

    public static void displayPremiumTweetForFreeUser(TweetPost tweet){
        System.out.println(tweet.toStringFor280());
        if (tweet.isPremium()) {
            System.out.println("This is a Premium Post with 280 char limit");
        }
    }

    public static void displayAll(List<TweetPost> tweetList){
        System.out.println("####################Feed Section#####################");
        for (TweetPost post : tweetList) {
            TweetPostController.displayTweet(post);
            System.out.println();
        }
    }

    public static void displayAuthorSection(Author author, List<TweetPost> tweetList){
        System.out.println("####################Author Section#####################");
        for (TweetPost post : tweetList) {
            if (post.getAuthor().equals(author)) {
                displayTweet(post);
                System.out.println();
            }
        }
    }

    public static void userShowTweetPost(User user, List<TweetPost> tweetList){
        System.out.println("#################### Feed Section By User with limitation #####################");
        for (TweetPost post : tweetList) {
            if(!post.isPremium || user.isPremium()){
                TweetPostController.displayTweet(post);
                System.out.println();
            }
            else{
                TweetPostController.displayPremiumTweetForFreeUser(post);
                System.out.println();
            }
            
        }
        
    }
}
