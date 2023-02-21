package Projects.Sports_Social_News.views;

import java.util.ArrayList;
import java.util.Scanner;

import Projects.Sports_Social_News.controllers.ImageController;
import Projects.Sports_Social_News.models.posts.ImagePost;
import Projects.Sports_Social_News.models.users.AuthorUser;

public class CreateImageView {
    
    public AuthorUser author;

    public CreateImageView(AuthorUser author) {
        this.author = author;
    }

    public void createImageDialog() {

        ArrayList<String> images = new ArrayList<>();

        Scanner authorInput = new Scanner(System.in);
        System.out.println("Insert the date of publication:");
        String publicationDate = authorInput.nextLine();
        System.out.println("Insert your description:");
        String description = authorInput.nextLine();
        System.out.println("Insert the number of images you wish to upload (Minimum of 2):");
        int numImages = authorInput.nextInt();
        
        for (int i = 0; i < numImages; i++) {
            System.out.println("Insert the link for image " + i + ":");
            String image = authorInput.next();
            if(!image.isEmpty()) {images.add(image);}
            //images.add(image);
        }
        
        ImageController imageController = new ImageController();

        try {
            ImagePost image = imageController.createImagePost(publicationDate, author, images, description);
            imageController.display(image);

        } catch (Exception e) {
            System.out.println("Your post is not valid. Please try again.");
            System.out.println("Your description might be to big/inexistent or your images don't fill the requirements.");
        }
    }
}
