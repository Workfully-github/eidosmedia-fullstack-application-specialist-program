package org.workfully;

import org.workfully.controllers.users.AuthorController;
import org.workfully.controllers.users.BasicUserController;
import org.workfully.models.content.AbstractContent;
import org.workfully.utilities.UserType;
import org.workfully.utilities.factories.UserFactory;
import org.workfully.view.userSection.AuthorClientSideView;
import org.workfully.view.userSection.BasicUserClientSideView;

public class Sandbox {

    public static void main(String[] args) {

        /**
         * Please try the @see #SadBox
         */

        /* Do not delete */
        Bootstrap bootstrap = new Bootstrap();

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

         /* Two Authors */
        AuthorController amine = ((AuthorController) Bootstrap.userMocks.get(0));

        /* One Basic User */
        BasicUserController basicUserRicardo = new BasicUserController(
                UserFactory.createAbstractUser(UserType.BASICUSER, "Ricardo"));

        BasicUserClientSideView ricardoView = new BasicUserClientSideView(basicUserRicardo);

        /* One Content for quick access and testing */
        AbstractContent content = Bootstrap.getGlobalContentMapController().getGlobalMap().get(amine.getAuthorModel())
                .get(0);

        /* TESTING
         * Ability: 
         *  - to Like
         *  - to Write Comment
         *  - to view Home Feed
         *  - to see Limited/Premium Content;
         *  - to see Free/Content;
         * */        
        ricardoView.like(content);

        ricardoView.writeComment(content);

        ricardoView.saveFavourite(content);

        ricardoView.showHomeFeed();

        ricardoView.showFavouritePostDetail(0); // Will Throw Warning Message if Out of Bounds

        /* TESTING AUTHOR SECTION */

        AuthorClientSideView amineView = new AuthorClientSideView(amine);

        amineView.showAuthorSection();

    }
}
