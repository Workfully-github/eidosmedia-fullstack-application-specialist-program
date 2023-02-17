package Projects.Sports_Social_News.controllers;

import Projects.Sports_Social_News.models.posts.TweetPost;
import Projects.Sports_Social_News.models.users.AuthorUser;

public class Main {
    
    public static void main(String[] args) {
        
        //createTweet();
        
        AuthorUser hugo = new AuthorUser("hugo", "Hugo", "Esteves");

        TweetController tweetController = new TweetController();

        try {
            TweetPost tweet = tweetController.createTweetPost("17/02/2023", hugo, "It's project weekend...");
            tweetController.display(tweet);
            
        } catch (NullPointerException e) {
            System.out.println("Please enter a valid tweet");
        }


    }

    /* private static void createTweet() {
        AuthorUser hugo = new AuthorUser("hugo", "Hugo", "Esteves");
        TweetPost tweetPost = new TweetPost("16/02/2023", hugo, "It's finally friday!!!");
        
        System.out.println(hugo.getName());
        System.out.println(tweetPost.getPost());
    } */

}
