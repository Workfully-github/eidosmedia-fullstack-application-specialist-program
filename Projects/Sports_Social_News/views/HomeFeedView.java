package Projects.Sports_Social_News.views;

import java.util.ArrayList;
import java.util.HashMap;

import Projects.Sports_Social_News.models.GlobalPosts;
import Projects.Sports_Social_News.models.posts.ImagePost;
import Projects.Sports_Social_News.models.posts.Post;
import Projects.Sports_Social_News.models.posts.TextPost;
import Projects.Sports_Social_News.models.posts.TweetPost;
import Projects.Sports_Social_News.models.posts.VideoPost;
import Projects.Sports_Social_News.models.users.AuthorUser;
import Projects.Sports_Social_News.models.users.NormalUser;

public class HomeFeedView {
    
    public NormalUser user;

    public void showAllPosts() {
        // show all posts created
        System.out.println("-----------------------------------------------");
        System.out.println("### WELCOME TO THE HOME SECTION! ###");
        System.out.println("\n");
        System.out.println("# CHECK OUT OUR NEWS: #");
        System.out.println("\n");

        for (HashMap.Entry<AuthorUser,ArrayList<Post>> set : GlobalPosts.getGlobalPosts().entrySet()) {
            for (int i = 0; i < set.getValue().size(); i++) {

                // cast the post type
                // Refactor if I have time
                if (set.getValue().get(i) instanceof TweetPost) {
                    TweetPost tweet = (TweetPost) set.getValue().get(i);
                    System.out.println(tweet.getPost());
                    System.out.println("Comments: " + tweet.numberComments());
                    System.out.println("Likes: " + tweet.numberReactions());
                }
                if (set.getValue().get(i) instanceof TextPost) {
                    TextPost text = (TextPost) set.getValue().get(i);
                    System.out.println(text.getCoverImage());
                    System.out.println(text.getPost());
                    System.out.println(text.getIsFree());
                    System.out.println("Comments: " + text.numberComments());
                    System.out.println("Likes: " + text.numberReactions());
                }
                if (set.getValue().get(i) instanceof VideoPost) {
                    VideoPost video = (VideoPost) set.getValue().get(i);
                    System.out.println(video.getDescription());
                    System.out.println(video.getVideo());
                    System.out.println("Comments: " + video.numberComments());
                    System.out.println("Likes: " + video.numberReactions());
                }
                if (set.getValue().get(i) instanceof ImagePost) {
                    ImagePost image = (ImagePost) set.getValue().get(i);
                    for (int j = 0; j < image.getImages().size(); j++) {
                        System.out.println(image.getImages().get(j));
                    }
                    System.out.println(image.getDescription());
                    System.out.println("Comments: " + image.numberComments());
                    System.out.println("Likes: " + image.numberReactions());
                }
                
                System.out.println("This was posted by: " + set.getKey().getDisplayName());
                System.out.println("\n");
            }
        }
    }
}
