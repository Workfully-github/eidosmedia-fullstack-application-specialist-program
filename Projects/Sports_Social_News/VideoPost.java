package Projects.Sports_Social_News;

public class VideoPost extends Post {
    
    private String description, videoUrl;

    public VideoPost(String publicationDate, String sport, AuthorUser author, String description, String videoUrl) {
        super(publicationDate, sport, author);
        this.description = description;
        this.videoUrl = videoUrl;
    }
    
    public VideoPost(String publicationDate, AuthorUser author, String description, String videoUrl) {
        super(publicationDate, author);
        this.description = description;
        this.videoUrl = videoUrl;
    }
}
