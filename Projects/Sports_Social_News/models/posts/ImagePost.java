package Projects.Sports_Social_News.models.posts;

import java.util.ArrayList;

import Projects.Sports_Social_News.models.users.AuthorUser;

public class ImagePost extends Post {
    
    // how to define minlenght de 2?
    // how to define maxlenght de 280?
    // private static int POINTS_WIN = 3;
    private ArrayList<String> images;
    private String description;

    public ImagePost(String publicationDate, String sport, AuthorUser author, ArrayList<String> images, String description) {
        super(publicationDate, sport, author);
        this.images = images;
        this.description = description;
    }
    
    public ImagePost(String publicationDate, AuthorUser author, ArrayList<String> images, String description) {
        super(publicationDate, author);
        this.images = images;
        this.description = description;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public String getDescription() {
        return description;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AuthorUser getImageAuthor() {
        return getAuthor();
    }
}
