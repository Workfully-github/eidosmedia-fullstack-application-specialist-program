package org.workfully.controllers.users;

import org.workfully.models.content.AbstractContent;
import org.workfully.models.content.UserComment;
import org.workfully.models.reactions.LikeReaction;
import org.workfully.models.users.PremiumUser;
import org.workfully.utilities.facadeDP.ValidateUserInputUtils;

public class PremiumUserController extends AbstractUserController{
    
    private PremiumUser basicModel;

    /* CONSTRUCTOR */
    public PremiumUserController (PremiumUser basicModel) {
        this.basicModel = basicModel;
    }
    
    /* METHODS */
    @Override
    public UserComment comment(String comment, AbstractContent content) throws Exception {
        UserComment userComment = new UserComment(basicModel, ValidateUserInputUtils.validateMessage(comment));
        content.getCommentLogMap().add(userComment);
        return userComment;
    }

    @Override
    public void like(AbstractContent content) {
        content.getReactionLogMap().add(new LikeReaction(basicModel));

    }
}
