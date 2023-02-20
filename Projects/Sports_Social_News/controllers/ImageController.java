package Projects.Sports_Social_News.controllers;

import java.util.ArrayList;

import Projects.Sports_Social_News.models.posts.ImagePost;
import Projects.Sports_Social_News.models.users.AuthorUser;

public class ImageController {
    
    public ImagePost createImagePost(String publicationDate, AuthorUser author, ArrayList<String> images, String description) throws NullPointerException {

        if(description.isEmpty()) return null;
        if(description.length() > 280) return null;
        if(images.isEmpty()) return null;

        ImagePost image = new ImagePost(publicationDate, author, images, description);

        author.addPost(image);

        return image;
    }

    public ImagePost updateImageDescription(ImagePost image, String description) throws NullPointerException {

        if(description.isEmpty()) return null;
        if(description.length() > 280) return null;

        int index = image.getImageAuthor().getPosts().indexOf(image);
        image.setDescription(description);
        
        image.getImageAuthor().updatePost(image, index);

        return image;
    }

    public void deleteImagePost(ImagePost image) {
        int index = image.getImageAuthor().getPosts().indexOf(image);
        
        image.getImageAuthor().removePost(index);
    }

    public void display(ImagePost image) {
        System.out.println("Description: " + image.getDescription());
        for (int i = 0; i < image.getImages().size(); i++) {
            System.out.println(image.getImages().get(i));
        }
        System.out.println("By: " + image.getAuthor().getDisplayName());
    }
}
