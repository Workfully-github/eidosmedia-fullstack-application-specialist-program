package org.workfully;

import org.workfully.view.ClientSideView;

public class Sandbox {

    public static void main(String[] args) {

        ClientSideView view = new ClientSideView();

        /* TEST */
        view.writeTweet();

        view.writePostArticle();

        //view.showAuthorSection();

        view.showHomeFeed();
    }
}
