package org.workfully.controllers.users;

import org.workfully.controllers.content.CommentController;
import org.workfully.models.content.AbstractContent;
import org.workfully.models.reactions.LikeReaction;
import org.workfully.models.users.AbstractUser;
import org.workfully.models.users.userInterfaces.CommentContent;
import org.workfully.models.users.userInterfaces.LikeContent;

public abstract class AbstractUserController implements CommentContent, LikeContent {

    protected AbstractUser userModel;
    protected CommentController commentController;

    public AbstractUserController(AbstractUser userModel) {
        this.userModel = userModel;
        this.commentController = new CommentController();
    }

    /* This Controllers can be used by every AbstractUser */
    @Override
    public void comment(String comment, AbstractContent content) throws Exception {
        commentController.comment(this.userModel, comment, content);
    }

    @Override
    public void like(AbstractContent content) {
        content.getReactionLogMap().add(new LikeReaction(this.userModel));
    }

    public String getName(){
        return userModel.getUserName();
    }
}
