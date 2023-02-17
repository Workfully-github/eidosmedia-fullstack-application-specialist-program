package org.workfully;

import static org.workfully.utilities.UserType.*;

import java.util.ArrayList;

import org.workfully.controllers.users.AuthorController;
import org.workfully.factories.UserFactory;
import org.workfully.models.users.AbstractUser;
import org.workfully.models.users.Author;
import org.workfully.view.section.AbstractSection;

public class Bootstrap {

    public ArrayList<AbstractUser> userMocks() {
        return new ArrayList<AbstractUser>() {
            {
                add(UserFactory.createAbstractUser(PREMIUMUSER, "Ricardo"));
                add(UserFactory.createAbstractUser(BASICUSER, "Hugo"));
                add(UserFactory.createAbstractUser(AUTHOR, "Amine"));
            }
        };
    }

    public AuthorController mockController(Author model){
        return new AuthorController(model);
    }
}
