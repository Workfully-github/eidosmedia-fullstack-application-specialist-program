package Projects.Sports_Social_News.models.posts;

import Projects.Sports_Social_News.models.users.AuthorUser;

public class VideoPost extends Post {
    
    // how to define maxlenght de 280?
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

    public String getDescription() {
        return description;
    }

    public String getVideo() {
        return videoUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVideo(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public AuthorUser getVideoAuthor() {
        return getAuthor();
    }
}
