package Model.Content;

import java.util.ArrayList;

import Model.Users.Author;

public class ImageGallery extends Content {
    private ArrayList<String> images;
    
    public ImageGallery (Author author,  Boolean isContentPremium, String body, ArrayList<String> images){
        super(author, body, isContentPremium);
        this.images = images;
    }

    public String getImagesLinks() {
        String imagesLinks = "";
        for(String imageLink : images){
            imagesLinks = imagesLinks.concat("\n" +imageLink);
        }
        return imagesLinks;
    }

    public int getLinksNum(){
        return images.size();
    }
}
