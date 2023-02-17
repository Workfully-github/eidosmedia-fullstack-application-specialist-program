package views;

import controllers.TweetController;
import models.contents.TweetContent;
import models.users.AuthorUser;

import java.util.Scanner;

public class CreateTweetView {

    AuthorUser author;

    public CreateTweetView(AuthorUser author){
        this.author = author;
    }


    public void createTweetDialog(){

        Scanner in  = new Scanner(System.in);
        System.out.println("Insert title:");
        String title = in.nextLine();
        System.out.println("Insert body:");
        String body = in.nextLine();

        TweetController tweetController = new TweetController();
        try{
            TweetContent tweet = tweetController.createTweetPost(author,title, body);
            tweetController.displayTweet(tweet);

        }catch (NullPointerException exception){
            System.out.println("The tweet is not valid");
        }


    }



}
