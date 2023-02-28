package org.workfully.Sandboxes;

import java.io.FileReader;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.workfully.controllers.users.AbstractUserController;
import org.workfully.controllers.users.AuthorController;
import org.workfully.utilities.Bootstrap;
import org.workfully.view.userSection.AuthorClientSideView;

public class JsonSandbox {

    public static void main(String[] args) {

        Bootstrap bootstrap = new Bootstrap();

        try {

            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser
                    .parse(new FileReader("src/main/java/org/workfully/Sandboxes/homeFeedContents.json"));

            Map<String, AbstractUserController> userMocks = Bootstrap.bootstrapUsersFromJson(jsonArray);

            Bootstrap.bootstrapContentFromJson(jsonArray);

            AuthorClientSideView userView = new AuthorClientSideView((AuthorController) userMocks.get("Amine"));

            userView.showHomeFeed();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
