package org.workfully.Sandboxes;

import java.util.Map;

import org.json.simple.JSONArray;
import org.workfully.controllers.users.AbstractUserController;
import org.workfully.controllers.users.AuthorController;
import org.workfully.utilities.Bootstrap;
import org.workfully.utilities.factories.StringFactory;
import org.workfully.view.userSection.AuthorClientSideView;

public class JsonSandbox {

    public static JSONArray JSON_ARRAY = Bootstrap.generateJsonArray(StringFactory.JSON_PATH); //"src/main/java/org/workfully/Sandboxes/homeFeedContents.json"

    public static void main(String[] args) {

        Bootstrap bootstrap = new Bootstrap();

        try {

            Map<String, AbstractUserController> userMocks = Bootstrap.bootstrapUsersFromJson(JSON_ARRAY);

            Bootstrap.bootstrapContentFromJson(JSON_ARRAY);

            AuthorController amine = (AuthorController) userMocks.get("Amine");
            AuthorClientSideView userView = new AuthorClientSideView(amine);

            amine.createTweetToJson("This tweet was manually written.");
            //amine.createTweet("Test");

            userView.showHomeFeed();            


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
