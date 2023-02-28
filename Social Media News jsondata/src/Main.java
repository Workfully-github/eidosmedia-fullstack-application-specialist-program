
import Controller.TweetPostController;
import Models.Content.ImagePost;
import Models.Content.TextPost;
import Models.Content.TweetPost;
import Models.Content.VideoPost;
import Models.User.Author;
import Models.User.BasicUser;
import Models.User.PremuimUser;
import View.InitPost_json;
import View.InitUser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String json ="{\"feed\": {\n" +
                "  \"tweets\": [\n" +
                "    {\n" +
                "      \"title\": \"tweet for today\",\n" +
                "      \"text\": \"we just receive 100 dollars order from our platform\",\n" +
                "      \"author\": {\n" +
                "        \"name\": \"John Doe\",\n" +
                "        \"id\": \"1\",\n" +
                "        \"type\": \"basic\"\n" +
                "      },\n" +
                "      \"likes\": [],\n" +
                "      \"comments\": [],\n" +
                "      \"premium\": true\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"My Second Post\",\n" +
                "      \"text\": \"Goodbye World!\",\n" +
                "      \"author\": {\n" +
                "        \"name\": \"John Doe\",\n" +
                "        \"id\": \"1\",\n" +
                "        \"type\": \"basic\"\n" +
                "      },\n" +
                "      \"likes\": [],\n" +
                "      \"comments\": [],\n" +
                "      \"premium\": false\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"a other Post\",\n" +
                "      \"text\": \"Hello World!\",\n" +
                "      \"author\": {\n" +
                "        \"name\": \"Bob\",\n" +
                "        \"id\": \"2\",\n" +
                "        \"type\": \"premium\"\n" +
                "      },\n" +
                "      \"likes\": [{\n" +
                "        \"name\": \"John Doe\",\n" +
                "        \"id\": \"1\",\n" +
                "        \"type\": \"basic\",\n" +
                "        \"author\": true\n" +
                "      }],\n" +
                "      \"comments\": [\n" +
                "        {\n" +
                "            \"user\":{\n" +
                "                \"name\": \"patrick\",\n" +
                "                \"id\": \"4\",\n" +
                "                \"type\": \"premium\",\n" +
                "                \"author\": false\n" +
                "              },\n" +
                "          \"text\": \"best post of the year\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"premium\": false\n" +
                "    }\n" +
                "  ],\n" +
                "  \"videos\": [],\n" +
                "  \"texts\": [],\n" +
                "  \"images\": []\n" +
                "}\n" +
                "}\n";

        //Declare Contents
        List<TweetPost> tweetPostsList = new ArrayList();
        List<VideoPost> videoPostsList = new ArrayList();
        List<TextPost> textPostsList = new ArrayList();
        List<ImagePost> imagePostsList = new ArrayList();

        //var declaration
        BasicUser userBasic;
        PremuimUser premiumUser;
        Author authorVar;
        TweetPost tweetPostVar;

        //read json
        JSONObject jsonObject = new JSONObject(json);
        JSONObject jsonFeed = jsonObject.getJSONObject("feed");


        // tweetList
        JSONArray tweetsJson = jsonFeed.getJSONArray("tweets");
        for (int i = 0; i < tweetsJson.length(); i++) {

            JSONObject jsonObjectTweet = tweetsJson.getJSONObject(i);
            tweetPostVar = InitPost_json.createTweetPost(jsonObjectTweet);
            tweetPostsList.add(tweetPostVar);
        }

        TweetPostController.displayAll(tweetPostsList);
    }
}