package Projects.Sports_Social_News.views;

import org.w3c.dom.Text;

import Projects.Sports_Social_News.controllers.ImageController;
import Projects.Sports_Social_News.controllers.TextController;
import Projects.Sports_Social_News.controllers.TweetController;
import Projects.Sports_Social_News.controllers.VideoController;
import Projects.Sports_Social_News.models.posts.ImagePost;
import Projects.Sports_Social_News.models.posts.TextPost;
import Projects.Sports_Social_News.models.posts.TweetPost;
import Projects.Sports_Social_News.models.posts.VideoPost;
import Projects.Sports_Social_News.models.users.AuthorUser;
import Projects.Sports_Social_News.models.users.NormalUser;

public class CreatePostsHelper {
    
    public void createInitialPosts() {
        
        AuthorUser amine = new AuthorUser("amine", "Amine", "Nokra");
        AuthorUser abderraouf = new AuthorUser("abderraouf", "Abderraouf", "Rahmani");
        NormalUser ricardoNormal = new NormalUser("ricardo", "Ricardo", "Mendes", false);
        NormalUser sidiPremium= new NormalUser("sidi", "Sidi", "Toure", true);
    
        // CREATE POST TO FILL THE HOME SECTION
        // Tweet
        TweetController tweetController = new TweetController();
        TweetPost tweet = tweetController.createTweetPost("20/02/2023", amine, "Remember guys! If it's to much code, it should be a class!!!");
    
        // Text
        TextController textController = new TextController();
        TextPost text1 = textController.createTextPost(
            "21/02/2023", 
            abderraouf, 
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit.Praesent sed urna mattis, vestibulum dolor ut, pellentesque libero. Vestibulum tincidunt, sapien eget ultrices blandit, tortor augue dapibus massa, ut ullamcorper eros ante eget metus. Ut odio sapien, elementum sit amet ex at, ultrices placerat neque. Aenean sit amet magna vel mi dignissim lobortis. Quisque sagittis eu leo vitae imperdiet. Nulla purus nisi, hendrerit vitae arcu non, lobortis dictum nisl. Curabitur blandit nisl ac urna eleifend vestibulum. Cras quis neque sollicitudin risus porta luctus a ac risus. Morbi et leo eget odio laoreet mollis. Vestibulum ut neque ante. Nunc luctus non ante sit amet pulvinar. Nulla dapibus lorem non urna elementum, at ornare nisi consequat. Interdum et malesuada fames ac ante ipsum primis in faucibus. Aliquam erat volutpat. Suspendisse tempus est bibendum eros volutpat, sit amet dignissim dolor commodo. Pellentesque in tempor massa. Proin hendrerit magna a ipsum pretium, nec facilisis sapien pretium. Suspendisse venenatis justo et tortor ultricies, quis faucibus est porttitor. Nullam eu velit nec tellus egestas posuere et vel mauris. Sed rhoncus felis vel neque volutpat, eget dictum nisi hendrerit. Aenean pharetra commodo risus, a dapibus nisi aliquet a. In varius sagittis fermentum. Sed mattis porta cursus. Aenean convallis tellus enim, elementum pretium enim porta vel. Nulla facilisi. Integer vulputate sit amet metus in bibendum. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc tincidunt ante quis lacus convallis, eleifend placerat orci sollicitudin. Suspendisse molestie luctus augue, venenatis ultrices ipsum cursus nec. Quisque scelerisque hendrerit tellus, in vestibulum velit. Aliquam accumsan pretium facilisis. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nam lobortis ante eu semper pretium. Ut elementum.",
            "arstdyhjnbgf.png", 
            true);
        
        TextPost text2 = textController.createTextPost(
            "18/02/2023", 
            abderraouf, 
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            "ilhkjgf.png", 
            false);
    
        // Video
        VideoController videoController = new VideoController();
        VideoPost video = videoController.createVideoPost("20/02/2023", amine, "Video about abstract classes!", "http://youtube.com");
    }
    

        
        
        /* HomeFeedView homeFeedView = new HomeFeedView();
        AuthorSectionView authorSectionView = new AuthorSectionView();
        //DetailsSectionView detailsSectionView = new DetailsSectionView();

        // Initialize Tweet View
        CreateTweetView createTweetView1 = new CreateTweetView(abderraouf);
        CreateTweetView createTweetView2 = new CreateTweetView(amine);
        // Initialize Video View
        CreateVideoView createVideoView1 = new CreateVideoView(abderraouf);
        CreateVideoView createVideoView2 = new CreateVideoView(amine);
        // Initialize Text View
        CreateTextView createTextView1 = new CreateTextView(abderraouf);
        CreateTextView createTextView2 = new CreateTextView(amine);
        // Initialize Image View
        CreateImageView createImageView1 = new CreateImageView(abderraouf);
        CreateImageView createImageView2 = new CreateImageView(amine); */
}
