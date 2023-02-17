package View;

import java.util.Scanner;

import Controller.CreateTweetsController;
import Model.Author;
import Model.Tweet;

public class CreateTweetView {
    Author author;

    public CreateTweetView(Author author) {
        this.author = author;
    }

    public void createTweetDialog() {
        Scanner in  = new Scanner(System.in);
        System.out.println("Insert Tweet Body:");
        String body = in.nextLine();

        CreateTweetsController createTweetsController = new CreateTweetsController();
        try {
            Tweet newTweet = createTweetsController.createTweet(author, body);
            createTweetsController.displayTweet(newTweet);
        } catch (NullPointerException e) {
            System.out.println("Invalid Tweet Body!");
        } 
      
    }
}
