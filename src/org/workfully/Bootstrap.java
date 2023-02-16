package org.workfully;

import org.workfully.users.AbstractUser;
import org.workfully.users.utilities.UserFactory;
import static org.workfully.users.utilities.UserType.*;

import java.util.ArrayList;

public class Bootstrap {

    public ArrayList<AbstractUser> bootstrapUserMocks() {
        return new ArrayList<AbstractUser>() {
            {
                add(UserFactory.createAbstractUser(PREMIUMUSER, "Ricardo"));
                add(UserFactory.createAbstractUser(BASICUSER, "Hugo"));
                add(UserFactory.createAbstractUser(AUTHOR, "Amine"));
            }
        };
    }
}
