package Projects.Sports_Social_News.views;

import Projects.Sports_Social_News.models.posts.ImagePost;
import Projects.Sports_Social_News.models.posts.Post;
import Projects.Sports_Social_News.models.posts.TextPost;
import Projects.Sports_Social_News.models.posts.TweetPost;
import Projects.Sports_Social_News.models.posts.VideoPost;
//import Projects.Sports_Social_News.models.users.User;

public class DetailsSectionView {
    
    //private User user;
    //private Post post;

    public void showPostDetail(Post post) {

        System.out.println("-----------------------------------------------");
        System.out.println("### SEE THE DETAILS OF THIS POST ###");

        // Print the post
        if (post instanceof TweetPost) {
            TweetPost tweet = (TweetPost) post;
            System.out.println(tweet.getTweetAuthor());
            System.out.println(tweet.getPost());
            System.out.println("\n");

            printComments(post);
            printLikes(post);
        }
        if (post instanceof TextPost) {

            TextPost text = (TextPost) post;

            //if (!text.getIsFree()) 

            System.out.println(text.getAuthor());
            System.out.println(text.getCoverImage());
            System.out.println(text.getPost());
            System.out.println(text.getIsFree());

            printComments(post);
            printLikes(post);
        }
        if (post instanceof VideoPost) {
            VideoPost video = (VideoPost) post;
            System.out.println(video.getAuthor());
            System.out.println(video.getDescription());
            System.out.println(video.getVideo());

            printComments(post);
            printLikes(post);
        }
        if (post instanceof ImagePost) {
            ImagePost image = (ImagePost) post;
            System.out.println(image.getAuthor());
            for (int j = 0; j < image.getImages().size(); j++) {
                System.out.println(image.getImages().get(j));
            }
            System.out.println(image.getDescription());

            printComments(post);
            printLikes(post);
        }
    }


    public void printComments(Post post) {
        System.out.println("Comments");

        if (post.getComments().isEmpty()) {
            System.out.println("No comments on this post yet.");
        }
        
        for (int i = 0; i < post.getComments().size(); i++) {
            System.out.println("|  " + post.getComments().get(i));
            System.out.println("\n");
        }
    }

    public void printLikes(Post post) {
        System.out.println("Likes: " + post.numberReactions());

        /* for (int i = 0; i < post.getReactions().size(); i++) {
            System.out.println("|  " + post.getReactions().get(i));
            System.out.println("\n");
        } */
    }

}
