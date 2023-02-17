package Projects.Sports_Social_News.controllers;

import Projects.Sports_Social_News.models.posts.TweetPost;
import Projects.Sports_Social_News.models.users.AuthorUser;

public class TweetController {
    
    public TweetPost createTweetPost(String publicationDate, AuthorUser author, String post) throws NullPointerException {

        if(post.isEmpty()) return null;
        if(post.length() > 280) return null;

        TweetPost tweet = new TweetPost(publicationDate, author, post);

        author.addPost(tweet);

        return tweet;
    }

    public void updateTweetPost() {

    }

    public void deleteTweetPost() {

    }

    public void display(TweetPost tweet) {
        System.out.println(tweet.getPost());
        System.out.println("By: " + tweet.getAuthor().getDisplayName());
    }
}
