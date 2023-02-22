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

    public ImagePost(ArrayList<String> images,String descriptionText, String postName, Author author, boolean isPremium) {
        super(postName, author);
        updateImageAndDescription(images, descriptionText);
        this.isPremium = isPremium;
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

    public String toStringFor280() {
        if(descriptionText.length() > 280){
            return "Title: " + postName + "\n" +
            "Image content: " + images + ".\n" +
            "Content: " + descriptionText.substring(0,280) + ".\n" +
            this.toStringContent();
        }
        return "Title: " + postName + "\n" +
        "Image content: " + images + ".\n" +
        "Content: " + descriptionText + ".\n" +
        this.toStringContent();
        
    }
    
}
