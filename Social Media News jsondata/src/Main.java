
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Home feed!");

        String url = "https://mocki.io/v1/6d2abb84-e28a-491e-b175-f04f299ed29f";
        String method = "GET";

        //read data
        String httpBodyJson = InitPost_json.getJsonData(url, method);
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
        JSONObject jsonObject = new JSONObject(httpBodyJson);
        JSONObject jsonFeed = jsonObject.getJSONObject("feed");


        // tweetList
        JSONArray tweetsJson = jsonFeed.getJSONArray("tweets");
        for (int i = 0; i < tweetsJson.length(); i++) {

            JSONObject jsonObjectTweet = tweetsJson.getJSONObject(i);
            tweetPostVar = InitPost_json.createTweetPost(jsonObjectTweet);
            tweetPostsList.add(tweetPostVar);
        }

        Author author2 =new Author("Bob", (InitUser.id++)+"", true);
        TweetPost tweetPost1 = new TweetPost("tweet for today", author2);
        tweetPost1.updateTweetPostText("we just receive 100 dollars order from our platform");
        tweetPostsList.add(tweetPost1);
        TweetPostController.displayAll(tweetPostsList);
    }
}