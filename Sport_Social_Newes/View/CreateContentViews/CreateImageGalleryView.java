package View.CreateContentViews;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.ContentControllers.CreateImagePostController;
import Controller.ContentControllers.CreateVideoPostController;
import Controller.FeedControllers.FeedController;
import Controller.Utils.Printer;
import Model.Feed;
import Model.Content.ImageGallery;
import Model.Users.Author;

public class CreateImageGalleryView extends CreateContentViews {
    @Override
    public void createContentDialog(Author author) {
        Scanner in  = new Scanner(System.in);
        Printer.printMultiLines("Insert your description:");
        String imageGalleryDesc = in.nextLine();

        Printer.printMultiLines("You need atleast 2 images to post an image gallery: [Enter 0 when done]");
        ArrayList<String> imagesLinks = new ArrayList<String>();
        String userInput = "";

        while(userInput != "00000"){
            String imageLink = in.nextLine();
            if(imageLink == ""){
                userInput = imageLink;
                break;
            }
                imagesLinks.add(imageLink);
        }

        Printer.printMultiLines("is this piece of content Premium?");
        Boolean isContentPremium = in.nextBoolean();
        CreateImagePostController createImagePostController = new CreateImagePostController();
        try {
            ImageGallery newImageGallery = createImagePostController.create(new ImageGallery(author, isContentPremium, imageGalleryDesc, imagesLinks));
            createImagePostController.display(newImageGallery, author, false, 0);
        } catch (NullPointerException e) {
            Printer.printMultiLines("Invalid images gallery Body!");
        } 
    }
}
