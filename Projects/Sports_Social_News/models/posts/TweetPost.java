package Projects.Sports_Social_News.models.posts;

import Projects.Sports_Social_News.models.users.AuthorUser;

public class TweetPost extends Post {
    
    private String post;

    public TweetPost(String publicationDate, String sport, AuthorUser author, String post) {
        super(publicationDate, sport, author);
        this.post = post;
    }
    
    public TweetPost(String publicationDate, AuthorUser author, String post) {
        super(publicationDate, author);
        this.post = post;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public AuthorUser getTweetAuthor() {
        return getAuthor();
    }
}
