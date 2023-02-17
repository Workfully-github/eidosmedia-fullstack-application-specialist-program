package org.workfully;

import java.util.ArrayList;

import org.workfully.users.AbstractUser;
import org.workfully.users.Author;
import static org.workfully.users.utilities.StringFactory.*;

public class Sandbox {

    public static void main(String[] args) throws Exception {

        Bootstrap bootstrap = new Bootstrap();

        /* TEST */
        ArrayList<AbstractUser> userMocks = bootstrap.bootstrapUserMocks();

        Author author = (Author) userMocks.get(2);
        
        System.out.println(author.createTweet("Today is a beautiful day.").getTextBody());

        
    }
}
