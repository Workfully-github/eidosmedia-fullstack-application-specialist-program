package org.workfully.view.userSection;

import java.util.logging.Logger;

import org.workfully.Bootstrap;
import org.workfully.controllers.users.BasicUserController;
import org.workfully.models.content.AbstractContent;
import org.workfully.view.section.HomeFeed;

public class BasicUserClientSideView extends AbstractClientSideView {

    public BasicUserClientSideView(BasicUserController userController) {
        this.userController = userController;
        this.log = Logger.getLogger(AuthorClientSideView.class.getName());
    }

    @Override
    public void read(AbstractContent content){
        content.getPostDetail().showPostDetailFree();
    }
    
    /* 
     * @see AbstractClientSideView#showHomeFeed()
     */
    @Override
    public void showHomeFeed() {
        HomeFeed homeFeed = new HomeFeed();
        homeFeed.setGlobalMap(Bootstrap.getGlobalContentMapController().getGlobalMap());

        homeFeed.showFreeHomeFeed();
    }

}
