package Projects.Sports_Social_News;

import java.util.ArrayList;

public class ImagePost extends Post {
    
    // how to define minlenght de 2?
    // private static int POINTS_WIN = 3;
    private ArrayList<String> images;

    public ImagePost(String publicationDate, String sport, AuthorUser author, ArrayList<String> images) {
        super(publicationDate, sport, author);
        this.images = images;
    }
    
    public ImagePost(String publicationDate, AuthorUser author, ArrayList<String> images) {
        super(publicationDate, author);
        this.images = images;
    }
}
