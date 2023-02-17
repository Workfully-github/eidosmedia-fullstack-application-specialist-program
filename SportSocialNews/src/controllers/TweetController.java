package controllers;

import models.contents.TweetContent;
import models.users.AuthorUser;

public class TweetController {


    public TweetContent createTweetPost(AuthorUser author,String title,String body) throws NullPointerException{
        if(body.isEmpty()) return null;
        if(body.length() > 280) return null;

        TweetContent tweet = new TweetContent(
            author,title,body
        );

        author.addContent(tweet);

        return tweet;


    }


    public void updateTweetPost(){

    }

    public void deleteTweet(){

    }

    public void getTweet(){




    }

    public void displayTweet(TweetContent tweet){
        System.out.println(tweet.getTitle());
        System.out.println(tweet.getBody());
        System.out.println("By: " + tweet.getAuthorUser().getDisplayName());


    }

}
