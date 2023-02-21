package Projects.Sports_Social_News.models;

import java.util.ArrayList;

import Projects.Sports_Social_News.models.posts.ImagePost;
import Projects.Sports_Social_News.models.posts.TextPost;
import Projects.Sports_Social_News.models.posts.TweetPost;
import Projects.Sports_Social_News.models.posts.VideoPost;

public class Wrapper {
    
    //public ArrayList<Wrapper> typePosts = new ArrayList<Wrapper>();
    public TweetPost tweet;
    public TextPost text;
    public VideoPost video;
    public ImagePost image;

    public Wrapper(TweetPost tweet) {
        this.tweet = tweet;
    }

    public Wrapper(TextPost text) {
        this.text = text;
    }

    public Wrapper(VideoPost video) {
        this.video = video;
    }

    public Wrapper(ImagePost image) {
        this.image = image;
    }
}
