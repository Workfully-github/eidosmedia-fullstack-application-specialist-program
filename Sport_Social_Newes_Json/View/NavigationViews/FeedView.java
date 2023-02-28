package View.NavigationViews;

import Controller.FeedControllers.FeedController;
import Model.Feed;
import Model.Users.Author;
import Model.Users.User;

public class FeedView {
    
    public static void show(User user){
        FeedController.displayFeedContent(Feed.getFeed(), user);
        
    }

    public static void showProfile(Author author){
        FeedController.displayFeedContent(author.getMyContent(), author);
    }

}
