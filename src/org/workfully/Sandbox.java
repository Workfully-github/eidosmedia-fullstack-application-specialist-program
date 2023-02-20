package org.workfully;

import org.workfully.view.ClientSideView;

public class Sandbox {

    public static void main(String[] args) {

        ClientSideView view = new ClientSideView();

        /* TEST */
        view.writeTweet();

        //view.writePostArticle();

        //view.showAuthorSection();
        //view.showHomeFeed();


        //System.out.println(view.getBootstrap().getGlobalContentMapController().getGlobalMap().get(view.getAuthorControllerAmine().getAuthorModel()));

        /* WRITE COMMENT */
        view.writeComment(view.getBootstrap().getGlobalContentMapController().getGlobalMap().get(view.getAuthorControllerAmine().getAuthorModel()).get(0));

        /* READ COMMENT */
        //System.out.println(view.getBootstrap().getGlobalContentMapController().getGlobalMap().get(view.getAuthorControllerAmine().getAuthorModel()).get(0).getCommentLogMap().get(0).getTextBody());

        /* SHOW POST DETAIL */
        view.getBootstrap().getGlobalContentMapController().getGlobalMap().get(view.getAuthorControllerAmine().getAuthorModel()).get(0).getPostDetail().showPostDetail();
        
    }
}
