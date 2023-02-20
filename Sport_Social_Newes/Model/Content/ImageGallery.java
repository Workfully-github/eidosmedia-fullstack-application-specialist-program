package Model.Content;

import java.util.ArrayList;

import Model.Users.Author;

public class ImageGallery extends Content {
    private ArrayList<String> images;
    
    public ImageGallery (Author author,  Boolean isContentPremium, String body, ArrayList<String> images){
        super(author, body, isContentPremium);
        this.images = images;
    }
}
