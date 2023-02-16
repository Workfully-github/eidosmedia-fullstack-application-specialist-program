package Projects.Sports_Social_News;

public class TextPost extends Post {
    
    private String post;

    public TextPost(String publicationDate, String sport, AuthorUser author, String post) {
        super(publicationDate, sport, author);
        this.post = post;
    }
    
    public TextPost(String publicationDate, AuthorUser author, String post) {
        super(publicationDate, author);
        this.post = post;
    }
}
