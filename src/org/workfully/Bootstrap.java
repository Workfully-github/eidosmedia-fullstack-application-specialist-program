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
    private AuthorController authorControllerAmine;
    private AuthorController authorControllerSidi;
    private AuthorController authorControllerAbdu;

    public Bootstrap() {
        this.userMocks = userMocks();
        this.globalContentMapController = bootstrapGlobalContentMapController();
        this.authorControllerAmine = mockController((Author) userMocks.get(2));
        this.authorControllerSidi = mockController((Author) userMocks.get(3));
        this.authorControllerAbdu = mockController((Author) userMocks.get(4));
        
        
        bootstrapGlobalMapToOtherControllers();
    }

    /* GETTERS */
    public AuthorController getAuthorController(int key) {
        switch (key) {
            case 1:
            return authorControllerAmine;
            case 2:
            return authorControllerSidi;
            default:
            return authorControllerAbdu;
        }
    }


    /* METHODS */
    public ArrayList<AbstractUser> userMocks() {
        return new ArrayList<AbstractUser>() {
            {
                add(UserFactory.createAbstractUser(PREMIUMUSER, "Ricardo"));
                add(UserFactory.createAbstractUser(BASICUSER, "Hugo"));
                add(UserFactory.createAbstractUser(AUTHOR, "Amine"));
                add(UserFactory.createAbstractUser(AUTHOR, "Sidi"));
                add(UserFactory.createAbstractUser(AUTHOR, "Abdu"));
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
        authorControllerAmine.setGlobalContentMapController(globalContentMapController);
        authorControllerSidi.setGlobalContentMapController(globalContentMapController);
        authorControllerAbdu.setGlobalContentMapController(globalContentMapController);
    }

    private GlobalContentMapController bootstrapGlobalContentMapController() {
        return new GlobalContentMapController(new GlobalContentMap());
    }

    /* GETTERS */
    public GlobalContentMapController getGlobalContentMapController() {
        return globalContentMapController;
    }

}
