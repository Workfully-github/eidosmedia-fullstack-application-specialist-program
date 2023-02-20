package SportSocialMedia.Models.Content;

import java.util.ArrayList;

import SportSocialMedia.Models.User.Author;

public class ImagePost extends Content {

    protected ArrayList<String> images = new ArrayList<>();
    protected String descriptionText = "";
    private static final int MAX_CHARACTERS = 280;

    public ImagePost(ArrayList<String> images,String descriptionText, String postName, Author author) {
        super(postName, author);
        updateImageAndDescription(images, descriptionText);
    }

    public void updateImageAndDescription(ArrayList<String> images,String descriptionText){
        if(images.size() < 2){
            throw new IllegalArgumentException("Invalid number of images: it should be > 2");
        }
        this.images = images;
        if(descriptionText == null || descriptionText.length() > MAX_CHARACTERS){
            throw new IllegalArgumentException("Invalid tweet text");
        }
        this.descriptionText = descriptionText;
    }

    public void addImage(String image){
        this.images.add(image);
    }

    @Override
    public String toString() {
        return "Title: " + postName + "\n" +
        "Image content: " + images + ".\n" +
        ", descriptionText=" + descriptionText + ";" +
        this.toStringContent();
    }

    
    
}
