package Controller.ContentControllers;
import Controller.InteractionControllers.HandleComments;
import Controller.Utils.Printer;
import Model.Content.Content;
import Model.Content.Text;
import Model.Users.User;
import View.InteractinsView.CreateInteractionsView;

import Controller.Utils.HandleAuth;
public class CreateTextPostController extends CreateContentController{
    @Override
    public Text create(Content content) throws NullPointerException {
        Text textContent = (Text) content;
        if(textContent.getBody().isEmpty() || textContent.getCoverImageSrc().isEmpty()) return null;
        pushContent(textContent);
        return textContent;
    }
    
    @Override
    public void display(Content text, User user, Boolean isFeedDisplay, int index){
         
        CreateInteractionsView createInteractionsView = new CreateInteractionsView();
        String textBody = HandleAuth.checkUserContentRelationship(user, text) ? text.getBody() : text.getBody().substring(0, 280) + "...[As a basic user you are limited to read the full content for this post]" ;
        Printer.printMultiLines("\n" + index, textBody, "By: " + text.getAuthor().getName());
        Printer.devider();
        Printer.printMultiLines("Likes: " + text.getLikes() + "  |   Comments: " + text.getComments().size() + "    |   Saves: " + text.getSavesCount());
        Printer.devider();
        HandleComments.displayComments(text);
        if(isFeedDisplay) return;
        createInteractionsView.displayInteractionOptions(text, user);
    
    }
}
