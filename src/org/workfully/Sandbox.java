package org.workfully;

import java.util.ArrayList;

import org.workfully.users.AbstractUser;

public class Sandbox {
    public static void main(String[] args) throws Exception {

        Bootstrap bootstrap = new Bootstrap();

        /* TEST */
        ArrayList<AbstractUser> userMocks = bootstrap.bootstrapUserMocks();

    }
}
