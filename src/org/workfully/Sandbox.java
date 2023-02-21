package org.workfully;

import org.workfully.controllers.users.AuthorController;
import org.workfully.controllers.users.BasicUserController;
import org.workfully.utilities.UserType;
import org.workfully.utilities.factories.UserFactory;
import org.workfully.view.userSection.AuthorClientSideView;
import org.workfully.view.userSection.BasicUserClientSideView;

public class Sandbox {

    public static void main(String[] args) {

        /** 
         * Please try the @see #SadBox 
         * */

         /* Do not delete */
        Bootstrap bootstrap = new Bootstrap();

        /* 
         * How to create a new user:
         * 1 - Instanciate a new Controller:
         *      -> new AuthorController
         *      -> new BasicUserController
         *      -> new PremiumUserController
         * 2 - Controllers require a model
         *      -> Use static #UserFactory#class: to create a model
         *      -> ex: newAuthorController(UserFactory.createAbstractUser(UserType.AUTHOR, "username"));
         * 3 - Enjoy
         */


    }
}
