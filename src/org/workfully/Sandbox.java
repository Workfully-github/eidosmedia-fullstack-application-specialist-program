package org.workfully;

import static org.workfully.factories.StringFactory.*;

import java.util.ArrayList;

import org.workfully.controllers.users.AuthorController;
import org.workfully.models.users.AbstractUser;
import org.workfully.models.users.Author;

public class Sandbox {

    public static void main(String[] args) throws Exception {

        Bootstrap bootstrap = new Bootstrap();

        /* TEST */
        ArrayList<AbstractUser> userMocks = bootstrap.userMocks();

        AuthorController author = bootstrap.mockController((Author)userMocks.get(2));
        
        author.createTweet("Today is a beautiful day.");
        author.createTweet("This is pretty cool, working with MVC");
        author.createTweet("I Just want you guys to know that I'm communicating with a controller not directly with a Model.");
        author.createTweet(threeHundredCharacters);
        
        author.getAuthorSectionView().updateView();

    }
}
