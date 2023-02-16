package Projects.Sports_Social_News;

public class TweetPost extends Post {
    
    // how to define maxlenght de 280?
    // private static int POINTS_WIN = 3;
    private String post;

    public TweetPost(String publicationDate, String sport, AuthorUser author, String post) {
        super(publicationDate, sport, author);
        this.post = post;
    }
    
    public TweetPost(String publicationDate, AuthorUser author, String post) {
        super(publicationDate, author);
        this.post = post;
    }
}
