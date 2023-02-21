package Projects.Sports_Social_News.views;

import Projects.Sports_Social_News.models.posts.ImagePost;
import Projects.Sports_Social_News.models.posts.TextPost;
import Projects.Sports_Social_News.models.posts.TweetPost;
import Projects.Sports_Social_News.models.posts.VideoPost;
import Projects.Sports_Social_News.models.users.AuthorUser;

public class AuthorSectionView {
    
    public AuthorUser author;

    public void showAllAuthorPosts(AuthorUser author) {

        System.out.println("-----------------------------------------------");
        System.out.println("### WELCOME TO YOUR SECTION! ###");
        System.out.println("\n");
        System.out.println("# CHECK OUT ALL YOUR POSTS: #");
        System.out.println("\n");

        for (int i = 0; i < author.getPosts().size(); i++) {

            if (author.getPosts().get(i) instanceof TweetPost) {
                TweetPost tweet = (TweetPost) author.getPosts().get(i);
                System.out.println(tweet.getPost());
                System.out.println("Comments: " + tweet.numberComments());
                System.out.println("Likes: " + tweet.numberReactions());
                
            }

            if (author.getPosts().get(i) instanceof TextPost) {
                TextPost text = (TextPost) author.getPosts().get(i);
                System.out.println(text.getPost());
                System.out.println("Comments: " + text.numberComments());
                System.out.println("Likes: " + text.numberReactions());
                
            }

            if (author.getPosts().get(i) instanceof ImagePost) {
                ImagePost image = (ImagePost) author.getPosts().get(i);
                System.out.println(image.getDescription());
                System.out.println("Comments: " + image.numberComments());
                System.out.println("Likes: " + image.numberReactions());
                
            }

            if (author.getPosts().get(i) instanceof VideoPost) {
                VideoPost video = (VideoPost) author.getPosts().get(i);
                System.out.println(video.getDescription());
                System.out.println("Comments: " + video.numberComments());
                System.out.println("Likes: " + video.numberReactions());
                
            }
            /* System.out.println(author.getPosts().get(i)); */
            System.out.println("Published on: " + author.getPosts().get(i).getDate());
            System.out.println("\n");
        }
    }
}
