package Controller.ContentControllers;
import Controller.InteractionControllers.HandleComments;
import Controller.Utils.Printer;
import Model.Content.Content;
import Model.Content.ImageGallery;
import Model.Users.User;
import View.InteractinsView.CreateInteractionsView;

public class CreateImagePostController extends CreateContentController{
    @Override
    public ImageGallery create(Content content) throws NullPointerException {
        ImageGallery imageContent = (ImageGallery) content;

        if(imageContent.getBody().isEmpty() || imageContent.getBody().length() > 280 || imageContent.getLinksNum() < 2) return null;
        pushContent(imageContent);
        return imageContent;
    }

    @Override
    public void display(Content content, User user, Boolean isFeedDisplay, int index){
        ImageGallery imageContent = (ImageGallery) content;
        CreateInteractionsView createInteractionsView = new CreateInteractionsView();
        Printer.printMultiLines("\n" + index, "Gallery Description: " + imageContent.getBody(), "Images Sourve: " + imageContent.getImagesLinks(), "By: " + imageContent.getAuthor().getName());
        Printer.devider();
        Printer.printMultiLines("Likes: " + imageContent.getLikes() + "  |   Comments: " + imageContent.getComments().size() + "    |   Saves: " + imageContent.getSavesCount());
        Printer.devider();
        HandleComments.displayComments(imageContent);
        if(isFeedDisplay) return;
        createInteractionsView.displayInteractionOptions(imageContent, user);
    }
}
