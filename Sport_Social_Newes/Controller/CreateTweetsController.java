package Controller;

import Model.Author;
import Model.Tweet;

public class CreateTweetsController  {
    public static Tweet createTweet(Author author, String tweetBody) throws NullPointerException {

        if(tweetBody.isEmpty() || tweetBody.length() > 280) return null;
        Tweet newTweet = new Tweet(author, tweetBody);
        author.addContent(newTweet);
        return newTweet;
    }

    public void displayTweet(Tweet tweet){
        System.out.println(tweet.getBody());
        System.out.println("By: " + tweet.getAuthor().getName());
    }
}
