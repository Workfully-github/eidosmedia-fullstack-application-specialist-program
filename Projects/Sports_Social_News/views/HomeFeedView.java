package Projects.Sports_Social_News.views;

import java.util.ArrayList;
import java.util.HashMap;

import Projects.Sports_Social_News.models.GlobalPosts;
import Projects.Sports_Social_News.models.posts.Post;
import Projects.Sports_Social_News.models.posts.TweetPost;
import Projects.Sports_Social_News.models.users.AuthorUser;
import Projects.Sports_Social_News.models.users.NormalUser;

public class HomeFeedView {
    
    NormalUser user;

  /*   public HomeFeedView(NormalUser user) {
        this.user = user;
    } */

    public void showAllPosts() {
        // show all posts created
        for (HashMap.Entry<AuthorUser,ArrayList<Post>> set : GlobalPosts.getGlobalPosts().entrySet()) {
            for (int i = 0; i < set.getValue().size(); i++) {

                // create more types
                TweetPost tweet = (TweetPost) set.getValue().get(i);
                System.out.println(tweet.getPost());
                System.out.println("This was posted by: " + set.getKey().getDisplayName());
            }
        }
    }
}
