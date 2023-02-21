package org.workfully.view;

import java.util.logging.Logger;

import org.workfully.Bootstrap;
import org.workfully.controllers.users.PremiumUserController;
import org.workfully.models.content.AbstractContent;
import org.workfully.view.section.HomeFeed;

public class PremiumUserClientSideView extends AbstractClientSideView {

    public PremiumUserClientSideView(PremiumUserController userController) {
        this.userController = userController;
        this.log = Logger.getLogger(AuthorClientSideView.class.getName());
    }

    public void read(AbstractContent content){
        content.getPostDetail().showPostDetail();
    }

    public void like(AbstractContent content){
        userController.like(content);
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
