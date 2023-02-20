package Controller.ContentControllers;

import java.util.ArrayList;

import Model.Content.ImageGallery;
import Model.Users.Author;

public class CreateImagePostController {
    public static ImageGallery createImageGalleryPost(Author author, String description, ArrayList<String> images, Boolean isPremiumContent) throws NullPointerException {
        if(description.isEmpty() || description.length() > 280 || images.size() < 2) return null;
        ImageGallery newImageGallery = new ImageGallery(author, isPremiumContent, description, images);
        author.addContent(newImageGallery);
        return newImageGallery;
    }
}
