import Controller.ContentControllers.CreateTweetsController;
import Model.Content.Tweet;
import Model.Storage.ContentTable;
import Model.Users.Author;
import View.CreateTweetView;

public class App {
    public static void main(String[] args) {
        // ContentTable contentTable = new ContentTable();
        Author someAuthor = new Author("Abderraouf Rahmani", "Abdu", "abdu@training.com", false);
        CreateTweetView createTweetView = new CreateTweetView(someAuthor);
        createTweetView.createTweetDialog();
    }
}
