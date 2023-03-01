package Projects.Sports_Social_News.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Projects.Sports_Social_News.models.GlobalPosts;
import Projects.Sports_Social_News.models.posts.TextPost;
import Projects.Sports_Social_News.models.posts.TweetPost;
import Projects.Sports_Social_News.models.posts.VideoPost;
import Projects.Sports_Social_News.models.users.AuthorUser;
import Projects.Sports_Social_News.models.users.NormalUser;
import Projects.Sports_Social_News.views.AuthorSectionView;
import Projects.Sports_Social_News.views.CreateImageView;
import Projects.Sports_Social_News.views.CreatePostsHelper;
import Projects.Sports_Social_News.views.CreateTextView;
import Projects.Sports_Social_News.views.CreateTweetView;
import Projects.Sports_Social_News.views.CreateVideoView;
import Projects.Sports_Social_News.views.HomeFeedView;

public class Main {

    private static final String HOME_PAGE = "H";
    private static final String AUTHORS_PAGE = "A";
    private static final String CREATE_PAGE = "C";
    private static final int BASIC = 1;
    private static final int AUTHOR = 2;
    private static final int PREMIUM = 3;
    private static final int TWEET = 1;
    private static final int TEXT = 2;
    private static final int IMAGE = 3;
    private static final int VIDEO = 4;
    
    public static void main(String[] args) throws IOException, ParseException {

        try {
            URL url = new URL("https://mocki.io/v1/f0b807be-1f60-49fb-a7a9-c1aeabdc1e70");
    
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            
            // setRequestMethod sets the action to do - GET, POST, DELETE, etc.
            httpURLConnection.setRequestMethod("GET");

            // Setting request headers
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            String contentType = httpURLConnection.getHeaderField("Content-Type");

/*             System.out.println(contentType);
            System.out.println("application/xml");
            System.out.println(contentType.equals("application/xml"));
            if (contentType.equals("application/xml")) System.out.println("it's done!"); */

            jsonResponse(httpURLConnection);

            //new CreatePostsHelper().createInitialPosts();

            init();
            
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void jsonResponse(HttpURLConnection con) throws IOException, ParseException {

        int status = con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        //in.close();
        // close the connection
        //con.disconnect();

        //System.out.println(content);

        readJsonResponse(content);        
    }

    public static void readJsonResponse(StringBuffer con) throws JSONException {

        try {
            System.out.println("\n");
            String responseString = con.toString();
            
            JSONObject response = new org.json.JSONObject(responseString);
            JSONArray homeJSONArray = response.getJSONArray("Home");

            System.out.println(homeJSONArray);

            for (int i = 0; i < homeJSONArray.length(); i++) {
                System.out.println(homeJSONArray.getJSONObject(i).getString("type").equals("Tweet"));
                
                if (homeJSONArray.getJSONObject(i).getString("type").equals("Tweet")) {
                    System.out.println("I passed if!");
                    TweetController tweetController = new TweetController();
                    System.out.println("I passed controller!");
                    TweetPost tweet = new TweetPost(homeJSONArray);
                    System.out.println("I'm inside tweet!");
                    System.out.println(tweet);
                    tweet = tweetController.createTweetPost(
                        tweet.getDate(),
                        tweet.getAuthor(),
                        tweet.getPost());

                } else if(homeJSONArray.getJSONObject(i).getString("type").equals("Image")) {
                    TextController textController = new TextController();
                    TextPost text = new TextPost(homeJSONArray);
                    text = textController.createTextPost(
                        text.getDate(),
                        text.getTextAuthor(),
                        text.getPost(),
                        text.getCoverImage(),
                        text.getIsFree());

                } else if(homeJSONArray.getJSONObject(i).getString("type").equals("Video")) {
                    VideoController videoController = new VideoController();
                    VideoPost video = new VideoPost(homeJSONArray);
                    video = videoController.createVideoPost(
                        video.getDate(),
                        video.getAuthor(),
                        video.getDescription(),
                        video.getVideo());
                }
            }

        } catch (Exception e) {
            e.getStackTrace();
        } 
    }

    public static void init() {

        System.out.println("\n");
        System.out.println("Welcome! Let's relax and read some news");
        
        selectUser();
    }
    
    public static void openChoice(AuthorUser author) {

        Scanner userInput = new Scanner(System.in);
        System.out.println("-----------------------------------------------");
        System.out.println("Please select where you want to go?");
        System.out.println("[H] --> Home");
        System.out.println("[A] --> Authors");
        System.out.println("[C] --> Create Post");
        System.out.print("Let's go to: ");

        String userChoice = userInput.nextLine();

        switch (userChoice) {
            case HOME_PAGE:
                // selectUser() calls the create dialog view based on the input of type of user and type of post
                new HomeFeedView(author).showAllPosts();
                break;
            case AUTHORS_PAGE:
                // see what user it is?
                // if it's author , use selectPost() method, else, print message saying it's not possible
                new AuthorSectionView().showAllAuthorPosts(author);
                break;
            case CREATE_PAGE:
                // see what user it is?
                // if it's author , use selectPost() method, else, print message saying it's not possible
                selectPost(author);
                break;
        }
    }

    // select type of user to loggin with
    public static void selectUser() {
        
        Scanner userInput = new Scanner(System.in);
        System.out.println("-----------------------------------------------");
        System.out.println("Let's see who you are!");
        System.out.println("\n");
        System.out.println("Which kind of user do you want to log in with?");
        System.out.println("[1] --> Basic");
        System.out.println("[2] --> Author");
        System.out.println("[3] --> Premium");
        System.out.print("Let's log in as: ");

        int userChoice = userInput.nextInt();

        switch (userChoice) {
            case BASIC:
                NormalUser basicUser = new NormalUser("medhi", "Medhi", "Taremi", false);
                new HomeFeedView(basicUser).showAllPosts();
                break;
            case AUTHOR:
                AuthorUser authorUser = new AuthorUser("mateus", "Mateus", "Uribe");
                openChoice(authorUser);
                break;
            case PREMIUM:
                NormalUser premiumUser = new NormalUser("sergio", "Sergio", "Conceicao", true);
                new HomeFeedView(premiumUser).showAllPosts();
                break;
        }
    }

    // select what kind of post to create
    public static void selectPost(AuthorUser author) {

        Scanner userInput = new Scanner(System.in);
        System.out.println("-----------------------------------------------");
        System.out.println("\n");
        System.out.println("What type of post are you creating?");
        System.out.println("[1] --> Tweet");
        System.out.println("[2] --> Text");
        System.out.println("[3] --> Image");
        System.out.println("[4] --> Video");
        System.out.print("Let's create some content: ");

        int userChoice = userInput.nextInt();

        switch (userChoice) {
            case TWEET:
                new CreateTweetView(author).createTweetDialog();
                openChoice(author);
                break;
            case TEXT:
                new CreateTextView(author).createTextDialog();
                openChoice(author);
                break;
            case IMAGE:
                new CreateImageView(author).createImageDialog();
                openChoice(author);
                break;
            case VIDEO:
                new CreateVideoView(author).createVideoDialog();
                openChoice(author);
                break;
        }
    }
}
