package Projects.Sports_Social_News.controllers;

import Projects.Sports_Social_News.models.posts.TweetPost;
import Projects.Sports_Social_News.models.users.AuthorUser;
import Projects.Sports_Social_News.views.HomeFeedView;

public class Main {
    
    public static void main(String[] args) {
        
        AuthorUser hugo = new AuthorUser("hugo", "Hugo", "Esteves");
        AuthorUser ze = new AuthorUser("ze", "Jose", "Veiga");

        HomeFeedView homeFeedView = new HomeFeedView();

        TweetController tweetController = new TweetController();

        try {
            TweetPost tweet = tweetController.createTweetPost("17/02/2023", hugo, "It's project weekend...");
            TweetPost tweet2 = tweetController.createTweetPost("20/02/2023", hugo, "Let's start another week!");
            TweetPost tweet3 = tweetController.createTweetPost("21/02/2023", ze, "Let's finish this project");
   /*          tweetController.display(tweet);
            tweetController.display(tweet2);
            tweetController.updateTweetPost(tweet, "Actually, it's monday");
            tweetController.display(tweet);
            tweetController.display(tweet2);
            tweetController.deleteTweetPost(tweet2);
            tweetController.display(tweet);
            tweetController.display(tweet2); */

            homeFeedView.showAllPosts();

            /* for (int i = 0; i<hugo.getPosts().size(); i++) {
                System.out.println(hugo.getPost(i).getDate());
            } */
            
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
