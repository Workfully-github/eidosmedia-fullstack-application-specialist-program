package org.workfully;

import org.workfully.users.AbstractUser;
import org.workfully.users.PremiumUser;
import org.workfully.users.utilities.UserFactory;
import static org.workfully.users.utilities.UserType.*;

public class Bootstrap {

    public void bootstrapUsers(){

        PremiumUser premiumUser = UserFactory.createAbstractUser(PREMIUMUSER, "Ricardo");
        AbstractUser user = UserFactory.createAbstractUser(PREMIUMUSER, "Ricardo");
    }
    
}
