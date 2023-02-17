import Controller.CreateTweetsController;
import Model.Author;
import Model.Tweet;
import View.CreateTweetView;

public class App {
    public static void main(String[] args) {
        CreateTweetView createTweetView = new CreateTweetView(new Author("Abderraouf Rahmani", "Abdu", "abdu@training.com", false));
        createTweetView.createTweetDialog();
    }
}
