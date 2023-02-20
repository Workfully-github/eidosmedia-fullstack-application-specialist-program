package Controller.ContentControllers;

import Controller.InteractionControllers.HandleComments;
import Model.Content.Content;
import Model.Content.Tweet;
import Model.Users.Author;
import Model.Users.User;
import View.InteractinsView.CreateInteractionsView;

public class CreateTweetsController  {
    public Tweet createTweet(Author author, String tweetBody, Boolean isContentPremium) throws NullPointerException {
        
        if(tweetBody.isEmpty() || tweetBody.length() > 280) return null;
        Tweet newTweet = new Tweet(author, tweetBody, isContentPremium);
        author.addContent(newTweet);
        return newTweet;
    }
    
    public void displayTweet(Content tweet, User user){
        CreateInteractionsView createInteractionsView = new CreateInteractionsView();
        HandleComments handleComments = new HandleComments();

        System.out.println("\n" + tweet.getBody());
        System.out.println("By: " + tweet.getAuthor().getName());
        System.out.println("------------------------------------------");
        System.out.println("Likes: " + tweet.getLikes().size() + "  |   Comments: " + tweet.getComments().size() + "    |   Saves: " + tweet.getSaves().size());
        System.out.println("------------------------------------------");
        handleComments.displayComments(tweet);
        createInteractionsView.displayInteractionOptions(tweet, user);
    }

    

    public Tweet updateTweet(Tweet tweet, String body){
            tweet.setBody(body);
            return tweet;
    }
}
