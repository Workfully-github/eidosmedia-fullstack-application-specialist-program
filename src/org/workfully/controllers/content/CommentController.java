package org.workfully.controllers.content;

import org.workfully.models.content.AbstractContent;
import org.workfully.models.content.UserComment;
import org.workfully.models.users.AbstractUser;
import org.workfully.models.users.BasicUser;
import org.workfully.utilities.facadeDP.ValidateUserInputUtils;

public class CommentController {

    private UserComment userCommentModel; // To be used in order to retrieve POJO from DB later

    public CommentController() {
    }

    /*
     * To be used when DB is ready
     */
    public CommentController(UserComment userCommentModel) {
        this.userCommentModel = userCommentModel;
    }

    /*
     * Creates UserComment
     * Saves it in Author Content Log to be used in Author Section
     * Saves it to Global Content Map Controller
     */
    public UserComment comment(AbstractUser basicModel, String comment, AbstractContent content) throws Exception {
        userCommentModel = new UserComment(basicModel, ValidateUserInputUtils.validateMessage(comment));
        content.getCommentLogMap().add(userCommentModel);
        return userCommentModel;
    }
    
    
}
