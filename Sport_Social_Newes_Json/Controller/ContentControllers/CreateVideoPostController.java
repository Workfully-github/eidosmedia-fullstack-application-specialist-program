package Controller.ContentControllers;

import Controller.InteractionControllers.HandleComments;
import Controller.Utils.Printer;
import Model.Content.Content;
import Model.Content.Video;
import Model.Users.User;
import View.InteractinsView.CreateInteractionsView;

public class CreateVideoPostController extends CreateContentController {
    @Override
    public Video create(Content content) throws NullPointerException {
        Video videoContent = (Video) content;

        if(videoContent.getBody().isEmpty() || videoContent.getBody().length() > 280 || videoContent.getVideoSrc().isEmpty()) return null;
        pushContent(videoContent);
        return videoContent;
    }

    @Override
    public void display(Content content, User user, Boolean isFeedDisplay, int index){
        Video video = (Video) content;
        CreateInteractionsView createInteractionsView = new CreateInteractionsView();
        Printer.printMultiLines("\n" + index, video.getBody(), "Video Sourve: " + video.getVideoSrc(), "By: " + video.getAuthor().getName());
        Printer.devider();
        Printer.printMultiLines("Likes: " + video.getLikes() + "  |   Comments: " + video.getComments().size() + "    |   Saves: " + video.getSavesCount());
        Printer.devider();
        HandleComments.displayComments(video);
        
        // createInteractionsView.displayInteractionOptions(video, user);
    }

}
