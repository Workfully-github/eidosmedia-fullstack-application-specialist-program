package Projects.Sports_Social_News.controllers;

import Projects.Sports_Social_News.models.posts.VideoPost;
import Projects.Sports_Social_News.models.users.AuthorUser;
import Projects.Sports_Social_News.views.CreateImageView;
import Projects.Sports_Social_News.views.CreateTextView;
import Projects.Sports_Social_News.views.CreateTweetView;
import Projects.Sports_Social_News.views.CreateVideoView;
import Projects.Sports_Social_News.views.HomeFeedView;

public class Main {
    
    public static void main(String[] args) {
        
        AuthorUser hugo = new AuthorUser("hugo", "Hugo", "Esteves");
        AuthorUser ze = new AuthorUser("ze", "Jose", "Veiga");

        HomeFeedView homeFeedView = new HomeFeedView();
        // Initialize Tweet View
        CreateTweetView createTweetView1 = new CreateTweetView(ze);
        CreateTweetView createTweetView2 = new CreateTweetView(hugo);
        // Initialize Video View
        CreateVideoView createVideoView1 = new CreateVideoView(ze);
        CreateVideoView createVideoView2 = new CreateVideoView(hugo);
        // Initialize Text View
        CreateTextView createTextView1 = new CreateTextView(ze);
        CreateTextView createTextView2 = new CreateTextView(hugo);
        // Initialize Image View
        CreateImageView createImageView1 = new CreateImageView(ze);
        CreateImageView createImageView2 = new CreateImageView(hugo);

        try {
            /* createTweetView1.createTweetDialog();
            createTweetView1.createTweetDialog();
            createTweetView2.createTweetDialog();
            
            createVideoView1.createVideoDialog();
            createVideoView2.createVideoDialog();

            createTextView1.createTextDialog();
            createTextView2.createTextDialog();
            createImageView1.createTextDialog(); */
            createImageView2.createTextDialog();

            homeFeedView.showAllPosts();
            
        } catch (NullPointerException e) {
            System.out.println("Please enter a valid post");
        }


    }
}
