package org.workfully.users.utilities;

import org.workfully.users.AbstractUser;
import org.workfully.users.Author;
import org.workfully.users.BasicUser;
import org.workfully.users.PremiumUser;

public class UserFactory {

    public static <T extends AbstractUser> T createAbstractUser(UserType userType, String userName) {

        switch (userType) {
            case AUTHOR: return (T)new Author(userName);
            case BASICUSER: return (T)new BasicUser(userName);
            default: return (T)new PremiumUser(userName);
        }
            
    }
}
