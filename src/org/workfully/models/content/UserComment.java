package org.workfully.models.content;

import org.workfully.models.users.AbstractUser;

public class UserComment extends AbstractContent {

    public UserComment(AbstractUser user, String textBody) {
        super(user, textBody);
    }

}
