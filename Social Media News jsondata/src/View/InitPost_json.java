package View;

import Models.Content.TweetPost;
import Models.User.Author;
import Models.User.BasicUser;
import Models.User.PremuimUser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class InitPost_json {

    public static TweetPost createTweetPost(JSONObject jsonObjectTweet){

        //var declaration
        TweetPost tweetPostVar;
        BasicUser userBasic;
        PremuimUser premiumUser;
        Author authorVar;

        //creation of the post
        JSONObject jsonObjectAuthor = jsonObjectTweet.getJSONObject("author");
        authorVar = new Author(jsonObjectAuthor.getString("name"), jsonObjectAuthor.getString("id"), jsonObjectAuthor.getString("type")=="premium");
        tweetPostVar = new TweetPost(jsonObjectTweet.getString("title"), authorVar);
        tweetPostVar.updateTweetPostText(jsonObjectTweet.getString("text"));

        //add all likes
        JSONArray likeJson = jsonObjectTweet.getJSONArray("likes");
        for (int k = 0; k < likeJson.length(); k++) {
            JSONObject likeObjectAuthor = likeJson.getJSONObject(k);
            if(likeObjectAuthor.getBoolean("author")){
                authorVar = new Author(likeObjectAuthor.getString("name"), likeObjectAuthor.getString("id"), likeObjectAuthor.getString("type")=="premium");
                tweetPostVar.like(authorVar);
            }
            else if (likeObjectAuthor.getString("type")=="premium"){
                premiumUser = new PremuimUser(likeObjectAuthor.getString("name"), likeObjectAuthor.getString("id"));
                tweetPostVar.like(premiumUser);
            }
            else{
                userBasic = new BasicUser(likeObjectAuthor.getString("name"), likeObjectAuthor.getString("id"));
                tweetPostVar.like(userBasic);
            }
        }

        //add all comments
        JSONArray commentJson = jsonObjectTweet.getJSONArray("comments");
        for (int k = 0; k < commentJson.length(); k++) {
            JSONObject commentObjectAuthor = commentJson.getJSONObject(k).getJSONObject("user");
            if(commentObjectAuthor.getBoolean("author")){
                authorVar = new Author(commentObjectAuthor.getString("name"), commentObjectAuthor.getString("id"), commentObjectAuthor.getString("type")=="premium");
                tweetPostVar.comment(authorVar,commentJson.getJSONObject(k).getString("text"));
            }
            else if (commentObjectAuthor.getString("type")=="premium"){
                premiumUser = new PremuimUser(commentObjectAuthor.getString("name"), commentObjectAuthor.getString("id"));
                tweetPostVar.comment(premiumUser,commentJson.getJSONObject(k).getString("text"));
            }
            else{
                userBasic = new BasicUser(commentObjectAuthor.getString("name"), commentObjectAuthor.getString("id"));
                tweetPostVar.comment(userBasic,commentJson.getJSONObject(k).getString("text"));
            }
        }

        return tweetPostVar;

    }

    public static String getJsonData(String url, String method) throws IOException {

        HttpURLConnection connection =  (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod(method.toUpperCase());
        connection.setDoOutput(true);

        int responseCode;
        try {
            // Get Response Code and Headers
            responseCode = connection.getResponseCode();

            String responseMessage = connection.getResponseMessage();
            System.out.println("------------------------------------------------------------------");
            System.out.println("\nResponse Code: " + responseCode + " " + responseMessage);
            System.out.println("------------------------------------------------------------------");
            System.out.println("\nResponse Headers: " + connection.getHeaderFields());

            // Get Response Body (HTML)
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder responseBody = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                responseBody.append(inputLine);
            }
            System.out.println("\nResponse Body: " + responseBody.toString());
            return responseBody.toString();
        }
        catch (Exception e){
            System.out.println("Http request error");
            return "{}";
        }

    }

    public void addAllLikes(JSONArray likeJson){

    }

    public void addAllComments(JSONArray commentJson){

    }
}
