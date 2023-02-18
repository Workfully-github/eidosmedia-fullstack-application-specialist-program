package org.workfully;

import static org.workfully.utilities.UserType.*;

import java.util.ArrayList;

import org.workfully.controllers.users.AuthorController;
import org.workfully.controllers.users.GlobalContentMapController;
import org.workfully.models.content.GlobalContentMap;
import org.workfully.models.users.AbstractUser;
import org.workfully.models.users.Author;
import org.workfully.utilities.factories.UserFactory;

public class Bootstrap {

    /* PROPERTIES */
    private ArrayList<AbstractUser> userMocks;
    private GlobalContentMapController globalContentMapController;
    private AuthorController authorController;

    public Bootstrap() {
        this.userMocks = userMocks();
        this.globalContentMapController = bootstrapGlobalContentMapController();
        this.authorController = mockController((Author) userMocks.get(2));
        bootstrapGlobalMapToOtherControllers();
    }

    /* GETTERS */
    public AuthorController getAuthorController() {
        return authorController;
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

    private void bootstrapGlobalMapToOtherControllers() {
        authorController.setGlobalContentMapController(globalContentMapController);
    }

    private GlobalContentMapController bootstrapGlobalContentMapController() {
        return new GlobalContentMapController(new GlobalContentMap());
    }

    /* GETTERS */
    public GlobalContentMapController getGlobalContentMapController() {
        return globalContentMapController;
    }

}
