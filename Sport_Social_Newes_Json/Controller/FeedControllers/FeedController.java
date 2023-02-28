package Controller.FeedControllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import Controller.ContentControllers.CreateImagePostController;
import Controller.ContentControllers.CreateTextPostController;
import Controller.ContentControllers.CreateTweetsController;
import Controller.ContentControllers.CreateVideoPostController;
import Controller.Utils.Printer;
import Model.Feed;
import Model.Content.Content;
import Model.Content.ImageGallery;
import Model.Content.Text;
import Model.Content.Tweet;
import Model.Content.Video;
import Model.Users.Author;
import Model.Users.User;

public class FeedController {
    
    public static void createFeedPage(ArrayList<Content> storedContent){
            Feed.setFeed(storedContent);
            
    }
    
    public static void displayFeedContent(ArrayList<Content> allContent , User user) {
            Printer.devider();
            for(int i = 0; i < allContent.size(); i++){
                switch (allContent.get(i).getClass().toString()) {
                    case "class Model.Content.Tweet":
                         new CreateTweetsController().display(allContent.get(i), user, true, i);
                        break;
    
                    case "class Model.Content.Text":
                        new CreateTextPostController().display(allContent.get(i), user, true, i);
                        break;
                        case "class Model.Content.Video":
                        new CreateVideoPostController().display(allContent.get(i), user, true, i);
                        break;
                    case "class Model.Content.ImageGallery":
                        new CreateImagePostController().display(allContent.get(i), user, true, i);
                        break;
                    
                    default:
                        break;
                }
            
            }
            Printer.printMultiLines("You can read a post by entering the post index: ");
            Scanner in = new Scanner(System.in);
            int userInput = in.nextInt(); 

            switch (allContent.get(userInput).getClass().toString()) {
                case "class Model.Content.Tweet":
                     new CreateTweetsController().display(allContent.get(userInput), user, false, 0);
                    break;

                case "class Model.Content.Text":
                    new CreateTextPostController().display(allContent.get(userInput), user, false, 0);
                    break;
                    case "class Model.Content.Video":
                    new CreateVideoPostController().display(allContent.get(userInput), user, false, 0);
                    break;
                case "class Model.Content.ImageGallery":
                    new CreateImagePostController().display(allContent.get(userInput), user, false, 0);
                    break;
                
                default:
                    break;
            }
    
    }


    public static JSONObject getContentFromJson(URL GET_URL){
         // URL obj = new URL(GET_URL);
         try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) GET_URL.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = httpURLConnection.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
    
    
                while ((inputLine = in .readLine()) != null) {
                    response.append(inputLine);
                } in .close();

                return new JSONObject(response.toString());
                

            } else {
                System.out.println("GET request not worked");
                return null;
            }


            // int headerSize = httpURLConnection.getHeaderFields().size();
            // for(int i = 0; i < headerSize; i++) {
            //     System.out.println(httpURLConnection.getHeaderFieldKey(i) + " = " + httpURLConnection.getHeaderField(i));
            // }
            
        } catch (IOException e) {
            System.out.print(e.getMessage());
            return null;

        }
    }

    public static void parseContentJson(JSONObject respObject) throws NullPointerException{
        CreateTweetsController createTweetsController = new CreateTweetsController();
        CreateTextPostController createTextPostController = new CreateTextPostController();
        CreateImagePostController createImagePostController = new CreateImagePostController();
        CreateVideoPostController createVideoPostController = new CreateVideoPostController();

        Author abdu = new Author("Abderraouf", "Abdu", "sdfg@sdfg.co", true);
       JSONArray feed = respObject.getJSONArray("feed");
       for(int i = 0; i < feed.length(); i++) {
        JSONObject feedContent = feed.getJSONObject(i).getJSONObject("content");
        Boolean isContentPremium = feed.getJSONObject(i).getBoolean("isContentPremium");
        try {
            switch (feed.getJSONObject(i).getString("type")) {
                case "tweet":
                Tweet newTweet = createTweetsController.create(new Tweet(abdu, feedContent.getString("body"), isContentPremium));
                // Feed.addContenttoFeed(newTweet);
                break;
                
                case "textPost":
                Text newText = createTextPostController.create(new Text(abdu, isContentPremium, feedContent.getString("body"), feedContent.getString("coverImage")));
                // Feed.addContenttoFeed(newText);
                break;
                case "imageGallery":
                ArrayList<String> images = new ArrayList<>();
                for (int y = 0; y < feedContent.getJSONArray("images").length(); y++){
                    images.add(feedContent.getJSONArray("images").getString(y));
                }
                ImageGallery newGallery =  createImagePostController.create(new ImageGallery(abdu, isContentPremium, feedContent.getString("body"), images));
                // Feed.addContenttoFeed(newGallery);
                
                break;
                case "video":
                Video newVideo = createVideoPostController.create(new Video(abdu, isContentPremium, feedContent.getString("body"), feedContent.getString("video")));
                // Feed.addContenttoFeed(newVideo);
                
                break;
                
                default:
                break;
            }
                
        } catch (NullPointerException e) {
            Printer.printMultiLines("Invalid Tweet Body!");
        } 
       }
    }
}
