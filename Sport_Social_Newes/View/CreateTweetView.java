package View;

import java.util.Scanner;

import Controller.ContentControllers.CreateTweetsController;
import Controller.InteractionControllers.HandleComments;
import Controller.InteractionControllers.InteractionController;
import Model.Content.Tweet;
import Model.Users.Author;

public class CreateTweetView {
    Author author;

    public CreateTweetView(Author author) {
        this.author = author;
    }

    public void createTweetDialog() {
        Scanner in  = new Scanner(System.in);
        System.out.println("Insert Tweet Body:");
        String body = in.nextLine();

        System.out.println("is this piece of content Premium?");
        Boolean isContentPremium = in.nextBoolean();
        CreateTweetsController createTweetsController = new CreateTweetsController();
        try {
            Tweet newTweet = createTweetsController.createTweet(author, body, isContentPremium);
            createTweetsController.displayTweet(newTweet, author);
        } catch (NullPointerException e) {
            System.out.println("Invalid Tweet Body!");
        } 
    }
}
