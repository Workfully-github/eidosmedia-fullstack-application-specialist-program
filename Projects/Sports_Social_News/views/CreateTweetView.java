package Projects.Sports_Social_News.views;

import java.util.Scanner;

import Projects.Sports_Social_News.controllers.TweetController;
import Projects.Sports_Social_News.models.posts.TweetPost;
import Projects.Sports_Social_News.models.users.AuthorUser;

public class CreateTweetView {
    
    public AuthorUser author;

    public CreateTweetView(AuthorUser author) {
        this.author = author;
    }

    public void createTweetDialog() {
        Scanner authorInput = new Scanner(System.in);
        System.out.println("Insert the date of publication:");
        String publicationDate = authorInput.nextLine();
        System.out.println("Insert your tweet:");
        String post = authorInput.nextLine();
        
        TweetController tweetController = new TweetController();

        try {
            TweetPost tweet = tweetController.createTweetPost(publicationDate, author, post);
            tweetController.display(tweet);

        } catch (Exception e) {
            System.out.println("Your tweet is not valid. Please try again.");
        }
    }
}
