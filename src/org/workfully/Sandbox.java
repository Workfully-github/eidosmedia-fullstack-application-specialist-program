package org.workfully;

import org.workfully.controllers.users.AuthorController;
import org.workfully.controllers.users.BasicUserController;
import org.workfully.models.users.BasicUser;
import org.workfully.utilities.UserType;
import org.workfully.utilities.factories.UserFactory;
import org.workfully.view.BasicUserClientSideView;
import org.workfully.view.AuthorClientSideView;

public class Sandbox {

    public static void main(String[] args) {

        Bootstrap bootstrap = new Bootstrap();
        /* TEST */
        
        /* Mock model passed to controller for testing */
        AuthorController authorAmine = new AuthorController(UserFactory.createAbstractUser(UserType.AUTHOR, "Amine"));
        AuthorController authorHugo = new AuthorController(UserFactory.createAbstractUser(UserType.AUTHOR, "Hugo"));

        BasicUserController buRicardo = new BasicUserController(UserFactory.createAbstractUser(UserType.BASICUSER, "Ricardo")); 


        /* Pass controller @param authorAmine to view */
        AuthorClientSideView amineView = new AuthorClientSideView(authorAmine);

        AuthorClientSideView hugoView = new AuthorClientSideView(authorHugo);

        BasicUserClientSideView ricardoView = new BasicUserClientSideView(buRicardo);


        amineView.writePostArticle();
        hugoView.writePostArticle();

        //amineView.writeComment(Bootstrap.getGlobalContentMapController().getGlobalMap().get(authorAmine.getAuthorModel()).get(0));

        //ricardoView.writeComment(Bootstrap.getGlobalContentMapController().getGlobalMap().get(authorAmine.getAuthorModel()).get(0));
    


        //amineView.showHomeFeed();

        //hugoView.showAuthorSection();

        ricardoView.showHomeFeed();

    }
}
