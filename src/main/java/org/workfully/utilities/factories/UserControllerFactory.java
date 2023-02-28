package org.workfully.utilities.factories;

import org.json.simple.JSONObject;
import org.workfully.controllers.users.AbstractUserController;
import org.workfully.controllers.users.AuthorController;
import org.workfully.utilities.UserType;

public class UserControllerFactory {

    public static AbstractUserController generateUserControllerFromJson(JSONObject object) {
        return new AuthorController(UserFactory
                .createAbstractUser(UserType.AUTHOR,
                        ((JSONObject) object).get("contentAuthor").toString()));
    }
}
