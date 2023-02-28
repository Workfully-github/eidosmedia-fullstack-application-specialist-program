package org.workfully.view.userSection;

import java.util.logging.Logger;

import org.workfully.controllers.users.PremiumUserController;
import org.workfully.models.content.AbstractContent;
import org.workfully.utilities.Bootstrap;
import org.workfully.view.section.HomeFeed;

public class PremiumUserClientSideView extends AbstractClientSideView {

    public PremiumUserClientSideView(PremiumUserController userController) {
        this.userController = userController;
        this.log = Logger.getLogger(AuthorClientSideView.class.getName());
    }

    @Override
    public void read(AbstractContent content){
        content.getPostDetail().showPostDetail();
    }

    /* 
     * @see AbstractClientSideView#showHomeFeed()
     */
    @Override
    public void showHomeFeed() {
        HomeFeed homeFeed = new HomeFeed();
        homeFeed.setGlobalMap(Bootstrap.getGlobalContentMapController().getGlobalMap());

        homeFeed.showHomeFeed();
    }
}
