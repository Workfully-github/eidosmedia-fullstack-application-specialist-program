package View.CreateContentViews;

import java.util.Scanner;

import Controller.ContentControllers.CreateTextPostController;
import Controller.Utils.Printer;
import Model.Content.Text;
import Model.Users.Author;

public class CreateTextView extends CreateContentViews{
    @Override
    public void createContentDialog(Author author) {
        Scanner in  = new Scanner(System.in);
        Printer.printMultiLines("Insert blog post body:");
        String body = in.nextLine();

        Printer.printMultiLines("Insert blog post cover image:");
        String coverImage = in.nextLine();

        Printer.printMultiLines("is this piece of content Premium?");
        Boolean isContentPremium = in.nextBoolean();
        CreateTextPostController createTextPostController = new CreateTextPostController();
        try {
            Text newTweet = createTextPostController.create(new Text(author, isContentPremium, body, coverImage));
            createTextPostController.display(newTweet, author, false, 0);
        } catch (NullPointerException e) {
            Printer.printMultiLines("Invalid Tweet Body!");
        } 
    }
}
