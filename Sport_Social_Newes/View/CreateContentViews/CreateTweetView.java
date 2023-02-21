package View.CreateContentViews;

import java.util.Scanner;

import Controller.ContentControllers.CreateTweetsController;
import Controller.InteractionControllers.HandleComments;
import Controller.InteractionControllers.InteractionController;
import Controller.Utils.Printer;
import Model.Content.Tweet;
import Model.Users.Author;

public class CreateTweetView extends CreateContentViews {

   
    @Override
    public void createContentDialog(Author author) {
        Scanner in  = new Scanner(System.in);
        Printer.printMultiLines("Insert Tweet Body:");
        String body = in.nextLine();

        Printer.printMultiLines("is this piece of content Premium?");
        Boolean isContentPremium = in.nextBoolean();
        CreateTweetsController createTweetsController = new CreateTweetsController();
        try {
            Tweet newTweet = createTweetsController.create(new Tweet(author, body, isContentPremium));
            createTweetsController.display(newTweet, author, false, 0);
        } catch (NullPointerException e) {
            Printer.printMultiLines("Invalid Tweet Body!");
        } 
    }
}
