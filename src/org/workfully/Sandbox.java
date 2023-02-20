package org.workfully;

import org.workfully.controllers.users.AuthorController;
import org.workfully.utilities.UserType;
import org.workfully.utilities.factories.UserFactory;
import org.workfully.view.ClientSideView;

public class Sandbox {

    public static void main(String[] args) {

        Bootstrap bootstrap = new Bootstrap();
        /* TEST */
        // view.writeTweet();

        // view.writePostArticle();

        // view.showAuthorSection();
        // view.showHomeFeed();

        // System.out.println(view.getBootstrap().getGlobalContentMapController().getGlobalMap().get(view.getAuthorControllerAmine().getAuthorModel()));

        /* WRITE COMMENT */
        // view.writeComment(view.getBootstrap().getGlobalContentMapController().getGlobalMap().get(view.getAuthorController().getAuthorModel()).get(0));

        /* READ COMMENT */
        // System.out.println(view.getBootstrap().getGlobalContentMapController().getGlobalMap().get(view.getAuthorControllerAmine().getAuthorModel()).get(0).getCommentLogMap().get(0).getTextBody());

        /* SHOW POST DETAIL */
        // view.getBootstrap().getGlobalContentMapController().getGlobalMap().get(view.getAuthorController().getAuthorModel()).get(0).getPostDetail().showPostDetail();

        /* Mock model passed to controller for testing */
        AuthorController authorAmine = new AuthorController(UserFactory.createAbstractUser(UserType.AUTHOR, "Amine"));
        AuthorController authorHugo = new AuthorController(UserFactory.createAbstractUser(UserType.AUTHOR, "Hugo"));

        /* Pass controller @param authorAmine to view */
        ClientSideView amineView = new ClientSideView(authorAmine);

        ClientSideView hugoView = new ClientSideView(authorHugo);

        amineView.writeTweet();
        hugoView.writeTweet();
        hugoView.writeTweet();
        hugoView.writeTweet();

        amineView.showHomeFeed();

        hugoView.showAuthorSection();

        

    }
}
