package org.workfully;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.workfully.controllers.users.AuthorController;
import org.workfully.controllers.users.BasicUserController;
import org.workfully.models.content.AbstractContent;
import org.workfully.models.users.AbstractUser;
import org.workfully.models.users.Author;
import org.workfully.models.users.BasicUser;
import org.workfully.utilities.UserType;
import org.workfully.utilities.factories.UserFactory;
import org.workfully.view.section.HomeFeed;
import org.workfully.view.userSection.AuthorClientSideView;
import org.workfully.view.userSection.BasicUserClientSideView;

public class Sandbox {

    public static void main(String[] args) {

        /**
         * Please try the @see #SadBox
         */

        /* Do not delete */
        Bootstrap bootstrap = new Bootstrap();

        AuthorController amine = ((AuthorController) Bootstrap.userMocks.get(0));
        AuthorController hugo = ((AuthorController) Bootstrap.userMocks.get(1));

        /*
         * How to create a new user:
         * 1 - Instanciate a new Controller:
         * -> new AuthorController
         * -> new BasicUserController
         * -> new PremiumUserController
         * 2 - Controllers require a model
         * -> Use static #UserFactory#class: to create a model
         * -> ex: newAuthorController(UserFactory.createAbstractUser(UserType.AUTHOR,
         * "username"));
         * 3 - Enjoy
         */

        BasicUserController basicUserRicardo = new BasicUserController(
                UserFactory.createAbstractUser(UserType.BASICUSER, "Ricardo"));

        BasicUserClientSideView ricardoView = new BasicUserClientSideView(basicUserRicardo);

        AbstractContent content = Bootstrap.getGlobalContentMapController().getGlobalMap().get(amine.getAuthorModel())
                .get(0);
        ricardoView.like(content);

        ricardoView.writeComment(content);

        ricardoView.showHomeFeed();

    }
}
