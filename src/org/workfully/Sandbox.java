package org.workfully;

import org.workfully.controllers.users.AuthorController;
import org.workfully.models.users.BasicUser;
import org.workfully.utilities.UserType;
import org.workfully.utilities.factories.UserFactory;
import org.workfully.view.ClientSideView;

public class Sandbox {

    public static void main(String[] args) {

        Bootstrap bootstrap = new Bootstrap();
        /* TEST */
        
        /* Mock model passed to controller for testing */
        AuthorController authorAmine = new AuthorController(UserFactory.createAbstractUser(UserType.AUTHOR, "Amine"));
        AuthorController authorHugo = new AuthorController(UserFactory.createAbstractUser(UserType.AUTHOR, "Hugo"));

        //BasicUser buRicardo = new 


        /* Pass controller @param authorAmine to view */
        ClientSideView amineView = new ClientSideView(authorAmine);

        ClientSideView hugoView = new ClientSideView(authorHugo);

        amineView.writeTweet();
        hugoView.writeTweet();

        amineView.writeComment(Bootstrap.getGlobalContentMapController().getGlobalMap().get(authorAmine.getAuthorModel()).get(0));


        amineView.showHomeFeed();

        hugoView.showAuthorSection();


    }
}
