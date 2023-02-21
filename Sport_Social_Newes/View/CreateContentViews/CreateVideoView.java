package View.CreateContentViews;

import java.util.Scanner;

import Controller.ContentControllers.CreateVideoPostController;
import Controller.Utils.Printer;
import Model.Content.Video;
import Model.Users.Author;

public class CreateVideoView extends CreateContentViews{

    @Override
    public void createContentDialog(Author author) {
        Scanner in  = new Scanner(System.in);
        Printer.printMultiLines("Insert vides Description:");
        String videoDesc = in.nextLine();

        Printer.printMultiLines("Insert vides Link:");
        String videoLink = in.nextLine();

        Printer.printMultiLines("is this piece of content Premium?");
        Boolean isContentPremium = in.nextBoolean();
        CreateVideoPostController createVideoPostController = new CreateVideoPostController();
        try {
            Video newVideo = createVideoPostController.create(new Video(author, isContentPremium, videoDesc, videoLink));
            createVideoPostController.display(newVideo, author, false, 0);
        } catch (NullPointerException e) {
            Printer.printMultiLines("Invalid Tweet Body!");
        } 
    }
}
