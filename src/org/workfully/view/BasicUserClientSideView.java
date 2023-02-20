package org.workfully.view;

import java.util.logging.Logger;

import org.workfully.controllers.users.BasicUserController;
import org.workfully.models.content.AbstractContent;

public class BasicUserClientSideView extends AbstractClientSideView {

    public BasicUserClientSideView(BasicUserController userController) {
        this.userController = userController;
        this.log = Logger.getLogger(AuthorClientSideView.class.getName());
    }

    public void read(AbstractContent content){
        content.getPostDetail().showPostDetailFree();
    }

    @Override
    public void showHomeFeed() {
        super.showFreeHomeFeed();
    }

    
    
}
