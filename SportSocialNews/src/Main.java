import models.users.AuthorUser;
import views.CreateTweetView;

public class Main {


    public static void main(String[] args) {
        CreateTweetView createTweetView = new CreateTweetView(new AuthorUser("amine","Amine", "Nokra"));
        createTweetView.createTweetDialog();
    }
}
