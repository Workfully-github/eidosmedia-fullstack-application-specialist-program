package org.workfully.users;

import org.workfully.content.AbstractContent;

public class PremiumUser extends AbstractUser {

    /* CONSTRUCTORS */
    public PremiumUser() {
    }

    public PremiumUser(String userName) {
        super(userName);
    }

    /* BEHAVIOUR */
    @Override
    public void read(AbstractContent content) {
        // TODO Auto-generated method stub

    }

    @Override
    public void comment(String comment, AbstractContent content) {
        // TODO Auto-generated method stub

    }

    @Override
    public void like(AbstractContent content) {
        // TODO Auto-generated method stub

    }

}
