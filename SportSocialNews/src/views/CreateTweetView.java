package views;

import controllers.SportNewsAsyncListener;
import controllers.TweetController;
import models.contents.Content;
import models.contents.TweetContent;
import models.users.AuthorUser;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateTweetView implements SportNewsAsyncListener {

    AuthorUser author;
    TweetController tweetController = new TweetController();

    public CreateTweetView(AuthorUser author) {
        this.author = author;
    }

    public void createTweetDialog(){

        Scanner in  = new Scanner(System.in);
        System.out.println("Insert title:");
        String title = in.nextLine();
        System.out.println("Insert body:");
        String body = in.nextLine();

        TweetContent content = new TweetContent(
                new AuthorUser("a","a","a"),
                title,
                body
        );
        tweetController.create(content,this);



    }

    private void showLoader(boolean show){
        System.out.println("Creating post....");

    }


    @Override
    public void onSuccess(Content content) {
        showLoader(false);
        TweetContent tweetContent = (TweetContent) content;
        tweetController.display(tweetContent);
    }

    @Override
    public void onSuccess(ArrayList<Content> contents) {
        //UNUSED
    }

    @Override
    public void onError(String error) {
        System.out.println(error);
        showLoader(false);

    }
}
