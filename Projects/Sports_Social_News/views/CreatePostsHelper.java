package Projects.Sports_Social_News.views;

import Projects.Sports_Social_News.controllers.TextController;
import Projects.Sports_Social_News.controllers.TweetController;
import Projects.Sports_Social_News.controllers.VideoController;
import Projects.Sports_Social_News.models.interactions.Comment;
import Projects.Sports_Social_News.models.interactions.Reaction;
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
        NormalUser sidiPremium = new NormalUser("sidi", "Sidi", "Toure", true);
    
        // CREATE POST TO FILL THE HOME SECTION
        // Tweet
        TweetController tweetController = new TweetController();
        TweetPost tweet1 = tweetController.createTweetPost("20/02/2023", amine, "Remember guys! If it's to much code, it should be a class!!!");
    
        // Text
        TextController textController = new TextController();
        TextPost text1 = textController.createTextPost(
            "21/02/2023", 
            abderraouf, 
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit.Praesent sed urna mattis, vestibulum dolor ut, pellentesque libero.",
            "arstdyhjnbgf.png", 
            true);
            //Vestibulum tincidunt, sapien eget ultrices blandit, tortor augue dapibus massa, ut ullamcorper eros ante eget metus. Ut odio sapien, elementum sit amet ex at, ultrices placerat neque. Aenean sit amet magna vel mi dignissim lobortis. Quisque sagittis eu leo vitae imperdiet. Nulla purus nisi, hendrerit vitae arcu non, lobortis dictum nisl. Curabitur blandit nisl ac urna eleifend vestibulum. Cras quis neque sollicitudin risus porta luctus a ac risus. Morbi et leo eget odio laoreet mollis. Vestibulum ut neque ante. Nunc luctus non ante sit amet pulvinar. Nulla dapibus lorem non urna elementum, at ornare nisi consequat. Interdum et malesuada fames ac ante ipsum primis in faucibus. Aliquam erat volutpat. Suspendisse tempus est bibendum eros volutpat, sit amet dignissim dolor commodo. Pellentesque in tempor massa. Proin hendrerit magna a ipsum pretium, nec facilisis sapien pretium. Suspendisse venenatis justo et tortor ultricies, quis faucibus est porttitor. Nullam eu velit nec tellus egestas posuere et vel mauris. Sed rhoncus felis vel neque volutpat, eget dictum nisi hendrerit. Aenean pharetra commodo risus, a dapibus nisi aliquet a. In varius sagittis fermentum. Sed mattis porta cursus. Aenean convallis tellus enim, elementum pretium enim porta vel. Nulla facilisi. Integer vulputate sit amet metus in bibendum. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc tincidunt ante quis lacus convallis, eleifend placerat orci sollicitudin. Suspendisse molestie luctus augue, venenatis ultrices ipsum cursus nec. Quisque scelerisque hendrerit tellus, in vestibulum velit. Aliquam accumsan pretium facilisis. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nam lobortis ante eu semper pretium. Ut elementum.",
        
        TextPost text2 = textController.createTextPost(
            "18/02/2023", 
            abderraouf, 
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            "ilhkjgf.png", 
            false);
    
        // Video
        VideoController videoController = new VideoController();
        VideoPost video1 = videoController.createVideoPost("20/02/2023", amine, "Video about abstract classes!", "http://youtube.com");

        // Comments
        Comment comment1 = new Comment(sidiPremium, "Thanks Amine!");
        Comment comment2 = new Comment(ricardoNormal, "I always forget that...");

        // Reactions
        Reaction reaction1 = new Reaction(sidiPremium, true);
        Reaction reaction2 = new Reaction(ricardoNormal, true);

        // Add comments and likes
        tweet1.addCommentPost(comment1, sidiPremium);
        tweet1.addReactionPost(reaction1, sidiPremium);
        tweet1.addCommentPost(comment2, ricardoNormal);
        text1.addReactionPost(reaction2, ricardoNormal);
        text2.addReactionPost(reaction1, sidiPremium);
        text2.addReactionPost(reaction2, ricardoNormal);
        text2.addCommentPost(comment2, ricardoNormal);
        video1.addCommentPost(comment1, sidiPremium);
    }
}
