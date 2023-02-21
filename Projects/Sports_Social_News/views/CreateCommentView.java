package Projects.Sports_Social_News.views;

import java.util.Scanner;

import Projects.Sports_Social_News.models.interactions.Comment;
import Projects.Sports_Social_News.models.users.User;

public class CreateCommentView {

    /* public NormalUser user; */
    
    public void createCommentDialog(User user) {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Insert your comment:");
        String userChoice = userInput.nextLine();
        
        Comment comment = new Comment(user, userChoice);

        try {
            // create controler for comment
            /* TextPost text = textController.createTextPost(publicationDate, author, post, coverImage, isFree);
            textController.display(text); */

        } catch (Exception e) {
            System.out.println("Your post is not valid. Please try again.");
            System.out.println("Your post might be to big/inexistent or your image link doesn't exist.");
        }
    }
}
