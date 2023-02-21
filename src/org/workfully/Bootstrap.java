package org.workfully;

import java.util.ArrayList;

import org.workfully.controllers.content.GlobalContentMapController;
import org.workfully.controllers.users.AbstractUserController;
import org.workfully.controllers.users.AuthorController;
import org.workfully.controllers.users.BasicUserController;
import org.workfully.models.content.GlobalContentMap;
import org.workfully.models.users.Author;
import org.workfully.utilities.UserType;
import org.workfully.utilities.factories.UserFactory;

public class Bootstrap {

    private static GlobalContentMapController globalContentMapController;

    public Bootstrap() {
        this.globalContentMapController = bootstrapGlobalContentMapController();
    }

    public static GlobalContentMapController getGlobalContentMapController() {
        return globalContentMapController;
    }

    private GlobalContentMapController bootstrapGlobalContentMapController() {
        return new GlobalContentMapController(new GlobalContentMap());
    }

    public static ArrayList<AbstractUserController> userMocks() {
        return new ArrayList<AbstractUserController>() {
            {
                add(new AuthorController(UserFactory.createAbstractUser(UserType.AUTHOR, "Amine")));
                add(new AuthorController(UserFactory.createAbstractUser(UserType.AUTHOR, "Hugo")));
                add(new BasicUserController(UserFactory.createAbstractUser(UserType.BASICUSER, "Ricardo")));
            }
        };
    }

    public static void bootstrapContent(){
        AuthorController amine = ((AuthorController) userMocks().get(0));
        AuthorController hugo = ((AuthorController) userMocks().get(1));
        try {
            
            amine.createTweet("The most effective debugging tool is still careful thought, coupled with judiciously placed print statements. - Brian Kernighan");
            
            hugo.createTweet("The best way to predict the future is to implement it. - Alan Kay");
            
            amine.createTextPost("Programs must be written for people to read, and only incidentally for machines to execute. - Harold Abelson and Gerald Jay Sussman", "https://www.thisisnotarealwebsite.com", true);
            
            hugo.createImageGalleryPost("This is a ImageGallery Mock", "https://www.mockurl.com");
            
            amine.createVideoPost("Good code is its own best documentation. As you're about to add a comment, ask yourself, 'How can I improve the code so that this comment isn't needed? - Steve McConnell", "https://www.epsteindidntkillhimself.com");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
