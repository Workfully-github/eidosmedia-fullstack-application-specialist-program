package Projects.Sports_Social_News;

public class Post {

    private String publicationDate, sport;
    private AuthorUser author;

    public Post(String publicationDate, String sport, AuthorUser author) {
        
        this.publicationDate = publicationDate;
        this.sport = sport;
        this.author = author;
    }

    public Post(String publicationDate, AuthorUser author) {
        
        this.publicationDate = publicationDate;
        this.author = author;
    }

    public AuthorUser getAuthor() {
        return author;
    }
}
