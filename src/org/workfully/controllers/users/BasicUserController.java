package org.workfully.controllers.users;

import org.workfully.models.content.AbstractContent;
import org.workfully.models.content.UserComment;
import org.workfully.models.users.BasicUser;
import org.workfully.utilities.facadeDP.ValidateUserInput;

public class BasicUserController extends AbstractUserController {

    /* PROPERTIES */
    private BasicUser basicModel;

    /* CONSTRUCTOR */
    public BasicUserController(BasicUser basicModel) {
        this.basicModel = basicModel;
    }
    
    /* METHODS */
    @Override
    public UserComment comment(String comment, AbstractContent content) throws Exception {
        UserComment userComment = new UserComment(basicModel, ValidateUserInput.validateMessage(comment));
        content.getCommentLogMap().add(userComment);
        return userComment;
    }

    @Override
    public void like(AbstractContent content) {
        // TODO Auto-generated method stub

    }

}
