package org.workfully.utilities.factories;

import org.workfully.models.users.AbstractUser;
import org.workfully.models.users.Author;
import org.workfully.models.users.BasicUser;
import org.workfully.models.users.PremiumUser;
import org.workfully.utilities.UserType;

public class UserFactory {

    public static <T extends AbstractUser> T createAbstractUser(
            UserType userType,
            String userName) {
        switch (userType) {
            case AUTHOR:
                return (T) new Author(userName);
            case BASICUSER:
                return (T) new BasicUser(userName);
            default:
                return (T) new PremiumUser(userName);
        }
    }
}
