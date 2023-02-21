package org.workfully;

import java.util.ArrayList;

import org.workfully.controllers.content.GlobalContentMapController;
import org.workfully.controllers.users.AbstractUserController;
import org.workfully.controllers.users.AuthorController;
import org.workfully.controllers.users.BasicUserController;
import org.workfully.models.content.GlobalContentMap;
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

}
