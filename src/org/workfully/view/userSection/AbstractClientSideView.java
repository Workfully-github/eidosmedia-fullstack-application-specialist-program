package org.workfully.view.userSection;

import java.util.logging.Logger;

import org.workfully.controllers.users.AbstractUserController;
import org.workfully.models.content.AbstractContent;
import org.workfully.utilities.facadeDP.InputDialoguesUtils;

public abstract class AbstractClientSideView {

    protected AbstractUserController userController;
    protected Logger log;

    /*
     * when HomeFeed#Constructor() is called,
     * sets HomeFeed's global map with the existing global map
     * and then shows the feed fully updated
     * is abstract because of free/premium privillege and needs to be defined in sub-class
     */
    public abstract void showHomeFeed();

    /*
     * #BasicUser read differently from #PremiumUser
     */
    public abstract void read(AbstractContent content);
    
    public void writeComment(AbstractContent content) {
        InputDialoguesUtils.writeComment(this.userController, content, log);
    }

    public void like(AbstractContent content){
        userController.like(content);
    }
}
