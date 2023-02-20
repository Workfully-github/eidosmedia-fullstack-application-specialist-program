package org.workfully.view;

import static org.workfully.utilities.factories.StringFactory.*;

import java.util.Scanner;
import java.util.logging.Logger;

import org.workfully.controllers.users.AuthorController;
import org.workfully.models.content.TextPost;

public class AuthorClientSideView extends AbstractClientSideView {

    /* CONSTRUCTOR */
    public AuthorClientSideView(AuthorController userController) {
        this.userController = userController;
        this.log = Logger.getLogger(AuthorClientSideView.class.getName());
    }

    /* METHODS */
    public void writeTweet() {
        Scanner scCreateTweet = new Scanner(System.in);
        try {
            System.out.print("Write your Tweet: ");
            String scanInput = scCreateTweet.nextLine();
            ((AuthorController) userController).createTweet(scanInput);
        } catch (Exception e) {
            log.warning(e.getMessage());
        }
    }

    public void writePostArticle() {
        Scanner scMessage = new Scanner(System.in);
        try {
            System.out.print("Insert Cover Image URL: ");
            String URL = scMessage.nextLine();

            System.out.print("Write Post Article: ");
            String message = scMessage.nextLine();

            System.out.println("Is it Free or Premium?");
            System.out.println("1 - Free");
            System.out.println("2 - Premium");
            int selection = scMessage.nextInt();

            if(selection == 1)
            ((AuthorController) userController).createTextPost(message, URL);
        
            if(selection == 2){
                TextPost text = ((AuthorController) userController).createTextPost(message, URL);
                text.setPremium();
            }
            

            
        } catch (Exception e) {
            log.warning(e.getMessage());
        }
    }


    public void showAuthorSection() {
        ((AuthorController) userController).getAuthorSectionView().displayView();
    }
}
