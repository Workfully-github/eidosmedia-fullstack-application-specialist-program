package org.workfully;

import static org.workfully.utilities.UserType.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

import org.workfully.controllers.users.AuthorController;
import org.workfully.factories.UserFactory;
import org.workfully.models.users.AbstractUser;
import org.workfully.models.users.Author;

public class Bootstrap {

    /* PROPERTIES */
    private Logger log = Logger.getGlobal();
    private ArrayList<AbstractUser> userMocks = userMocks();

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

    public AuthorController mockController(Author model) {
        return new AuthorController(model);
    }

    public void writeTweet() {
        Scanner scCreateTweet = new Scanner(System.in);
        try {
            System.out.print("Write your Tweet: ");
            String scanInput = scCreateTweet.nextLine();
            mockController((Author) userMocks.get(2)).createTweet(scanInput);
        } catch (Exception e) {
            log.warning("Invalid Input Message");
        } finally {
            scCreateTweet.close();
        }
    }

    public void showAuthorSection() {
        mockController((Author) userMocks.get(2)).getAuthorSectionView().displayView();
    }
}
