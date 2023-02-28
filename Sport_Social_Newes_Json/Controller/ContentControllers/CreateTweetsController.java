package Controller.ContentControllers;
import Controller.InteractionControllers.HandleComments;
import Controller.Utils.Printer;
import Model.Content.Content;
import Model.Content.Tweet;
import Model.Users.User;
import View.InteractinsView.CreateInteractionsView;

public class CreateTweetsController extends CreateContentController  {
    @Override
    public Tweet create(Content content) throws NullPointerException {
        Tweet tweetContent = (Tweet) content;
        if(tweetContent.getBody().isEmpty() || tweetContent.getBody().length() > 280) return null;
        pushContent(tweetContent);
        System.out.print("a tweet created");
        return tweetContent;
    }
    
    @Override
    public void display(Content tweet, User user, Boolean isFeedDisplay, int index){
         
        CreateInteractionsView createInteractionsView = new CreateInteractionsView();
        Printer.printMultiLines("\n" + index, tweet.getBody(), "By: " + tweet.getAuthor().getName());
        Printer.devider();
        Printer.printMultiLines("Likes: " + tweet.getLikes() + "  |   Comments: " + tweet.getComments().size() + "    |   Saves: " + tweet.getSavesCount());
        Printer.devider();
        HandleComments.displayComments(tweet);
        if(isFeedDisplay) return;
        createInteractionsView.displayInteractionOptions(tweet, user);
    
    }
    
    

    public Tweet updateTweet(Tweet tweet, String body){
            tweet.setBody(body);
            return tweet;
    }
}
