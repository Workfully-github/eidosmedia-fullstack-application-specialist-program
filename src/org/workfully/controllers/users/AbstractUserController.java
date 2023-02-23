package org.workfully.controllers.users;

import org.workfully.controllers.content.CommentController;
import org.workfully.models.content.AbstractContent;
import org.workfully.models.reactions.LikeReaction;
import org.workfully.models.users.AbstractUser;
import org.workfully.models.users.userInterfaces.CommentContent;
import org.workfully.models.users.userInterfaces.LikeContent;
import org.workfully.models.users.userInterfaces.SaveFavourites;
import static org.workfully.utilities.factories.StringFactory.*;

public abstract class AbstractUserController implements CommentContent, LikeContent, SaveFavourites {

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

    @Override
    public void saveFavourite(AbstractContent content) {
        userModel.getFavouriteContentLogMap().add(content);
    }

    public void showFavouritePostDetail(int index) {

        try {
            printLn(FAVOURITE_HEADER);
            userModel.getFavouriteContentLogMap().get(index).getPostDetail().showPostDetail();
        } catch (Exception e) {
            printLn(NO_CONTENT_AVAILIABLE_AT_INDEX);
        }

    }

    public String getName() {
        return userModel.getUserName();
    }

    /*
     * Only for test purpsoes
     */
    public AbstractUser getUserModel() {
        return userModel;
    }
}
