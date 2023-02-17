import Controller.CreateTweetsController;
import Model.Author;
import Model.Tweet;
import Model.Storage.ContentTable;
import View.CreateTweetView;

public class App {
    public static void main(String[] args) {
        // ContentTable contentTable = new ContentTable();
        CreateTweetView createTweetView = new CreateTweetView(new Author("Abderraouf Rahmani", "Abdu", "abdu@training.com", false));
        createTweetView.createTweetDialog();
    }
}
