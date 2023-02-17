package org.workfully;

import static org.workfully.utilities.UserType.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

import org.workfully.controllers.users.AuthorController;
import org.workfully.controllers.users.GlobalContentMapController;
import org.workfully.factories.UserFactory;
import org.workfully.models.content.GlobalContentMap;
import org.workfully.models.users.AbstractUser;
import org.workfully.models.users.Author;

public class Bootstrap {

    /* PROPERTIES */
    private Logger log = Logger.getGlobal();
    private ArrayList<AbstractUser> userMocks;
    private GlobalContentMapController globalContentMapController;
    private AuthorController authorController;

    public Bootstrap() {
        this.userMocks = userMocks();
        this.globalContentMapController = bootstrapGlobalContentMapController();
        this.authorController = mockController((Author) userMocks.get(2));
        bootstrapGlobalMapToOtherControllers();
    }

    /* METHODS */
    private ArrayList<AbstractUser> userMocks() {
        return new ArrayList<AbstractUser>() {
            {
                add(UserFactory.createAbstractUser(PREMIUMUSER, "Ricardo"));
                add(UserFactory.createAbstractUser(BASICUSER, "Hugo"));
                add(UserFactory.createAbstractUser(AUTHOR, "Amine"));
            }
        };
    }

    /*
     * Change mockController in constructor @see #Bootstrap()
     */
    private AuthorController mockController(Author model) {
        return new AuthorController(model);
    }

    public void writeTweet() {
        Scanner scCreateTweet = new Scanner(System.in);
        try {
            System.out.print("Write your Tweet: ");
            String scanInput = scCreateTweet.nextLine();
            authorController.createTweet(scanInput);
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

            authorController.createTextPost(message, URL);
        } catch (Exception e) {
            log.warning(e.getMessage());
        }
    }

    private void bootstrapGlobalMapToOtherControllers() {
        authorController.setGlobalContentMapController(globalContentMapController);
    }

    private GlobalContentMapController bootstrapGlobalContentMapController() {
        return new GlobalContentMapController(new GlobalContentMap());
    }

    public void showAuthorSection() {
        mockController((Author) userMocks.get(2)).getAuthorSectionView().displayView();
    }
}
