package Projects.Sports_Social_News.controllers;

import Projects.Sports_Social_News.models.GlobalPosts;
import Projects.Sports_Social_News.models.posts.TweetPost;
import Projects.Sports_Social_News.models.users.AuthorUser;

public class TweetController {
    
    public TweetPost createTweetPost(String publicationDate, AuthorUser author, String post) throws NullPointerException {

        if(post.isEmpty()) return null;
        if(post.length() > 280) return null;
        
        TweetPost tweet = new TweetPost(publicationDate, author, post);
        
        author.addPost(tweet);
        GlobalPosts.addPostToGlobalPosts(author, tweet);

        return tweet;
    }

    public TweetPost updateTweetPost(TweetPost tweet, String post) throws NullPointerException {

        if(post.isEmpty()) return null;
        if(post.length() > 280) return null;

        int index = tweet.getTweetAuthor().getPosts().indexOf(tweet);
        tweet.setPost(post);
        
        tweet.getTweetAuthor().updatePost(tweet, index);
        GlobalPosts.updatePostToGlobalPosts(tweet.getTweetAuthor(), tweet);

        return tweet;
    }

    public void deleteTweetPost(TweetPost tweet) {
        int index = tweet.getTweetAuthor().getPosts().indexOf(tweet);
        
        tweet.getTweetAuthor().removePost(index);
        GlobalPosts.deletePostToGlobalPosts(tweet.getTweetAuthor(), tweet);
    }

    public void display(TweetPost tweet) {
        System.out.println(tweet.getPost());
        System.out.println("By: " + tweet.getAuthor().getDisplayName());
    }
}
