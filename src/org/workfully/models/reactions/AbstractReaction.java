package org.workfully.models.reactions;

import org.workfully.models.users.AbstractUser;

public abstract class AbstractReaction {

    /* PROPERTIES */
    private AbstractUser user;
    
    /* CONSTRUCTOR */
    public AbstractReaction(AbstractUser user) {
        this.user = user;
    }

    /* GETTERS */
    public AbstractUser getUser() {
        return user;
    }
}
