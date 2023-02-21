package Projects.Sports_Social_News.views;

import java.util.Scanner;

import Projects.Sports_Social_News.controllers.TextController;
import Projects.Sports_Social_News.models.posts.TextPost;
import Projects.Sports_Social_News.models.users.AuthorUser;

public class CreateTextView {
    
    public AuthorUser author;

    public CreateTextView(AuthorUser author) {
        this.author = author;
    }

    public void createTextDialog() {
        Scanner authorInput = new Scanner(System.in);
        System.out.println("Insert the date of publication:");
        String publicationDate = authorInput.nextLine();
        System.out.println("Insert your post:");
        String post = authorInput.nextLine();
        System.out.println("Insert your cover image:");
        String coverImage = authorInput.nextLine();
        System.out.println("Is this post free (true/false)?");
        boolean isFree = authorInput.nextBoolean();
        
        TextController textController = new TextController();

        try {
            TextPost text = textController.createTextPost(publicationDate, author, post, coverImage, isFree);
            textController.display(text);

        } catch (Exception e) {
            System.out.println("Your post is not valid. Please try again.");
            System.out.println("Your post might be to big/inexistent or your image link doesn't exist.");
        }
    }
}
