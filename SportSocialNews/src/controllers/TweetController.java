package controllers;

import models.contents.Content;
import models.contents.TweetContent;
import models.users.AuthorUser;

import java.util.concurrent.*;

public class TweetController extends ContentController {

    @Override
    public void create(Content content,SportNewsAsyncListener response){
        TweetContent tweetContent = (TweetContent) content;
         if(tweetContent.getBody().isEmpty()){
            response.onError("Error : empty body");
            return;
        }
        if(tweetContent.getBody().length() > 280){
            response.onError("Error : a tweet has max 280 characters");
            return;
        }

        /*TweetContent tweet = new TweetContent(
                author,tweetContent.getTitle(),tweetContent.getBody()
        );
        author.addContent(tweet);*/
        response.onSuccess(tweetContent);
    }


    public void updateTweetPost(){

    }

    public void deleteTweet(){

    }

    public void getTweet(){




    }

    public void display(TweetContent tweet){


    }

    @Override
    public void display(Content content) {
        super.display(content);
        TweetContent tweet = (TweetContent) content;
        System.out.println(tweet.getTitle());
        System.out.println(tweet.getBody());
        System.out.println("By: " + tweet.getAuthorUser().getDisplayName());

    }
}
