package org.workfully.models.reactions;

import org.workfully.models.users.AbstractUser;

public abstract class AbstractReaction {

    private AbstractUser user;

    public AbstractReaction(AbstractUser user) {
        this.user = user;
    }

    public AbstractUser getUser() {
        return user;
    }
}
