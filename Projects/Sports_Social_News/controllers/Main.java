package Projects.Sports_Social_News.controllers;

import java.util.Scanner;

import Projects.Sports_Social_News.models.posts.Post;
import Projects.Sports_Social_News.models.users.AuthorUser;
import Projects.Sports_Social_News.models.users.NormalUser;
import Projects.Sports_Social_News.views.AuthorSectionView;
import Projects.Sports_Social_News.views.CreateImageView;
import Projects.Sports_Social_News.views.CreatePostsHelper;
import Projects.Sports_Social_News.views.CreateTextView;
import Projects.Sports_Social_News.views.CreateTweetView;
import Projects.Sports_Social_News.views.CreateVideoView;
import Projects.Sports_Social_News.views.DetailsSectionView;
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
    
    public static void main(String[] args) {

        new CreatePostsHelper().createInitialPosts();
        init();
    }

    public static void init() {

        System.out.println("\n");
        System.out.println("Welcome! Let's relax and read some news");
        
        selectUser();

    }
    
    public static void openChoice(AuthorUser author) {

        Scanner userInput = new Scanner(System.in);
        System.out.println("-----------------------------------------------");
        System.out.println("Please select where you want to go");
        System.out.println("[H] --> Home");
        System.out.println("[A] --> Authors");
        System.out.println("[C] --> Create Post");
        System.out.print("Let's go to: ");

        String userChoice = userInput.nextLine();

        switch (userChoice) {
            case HOME_PAGE:
                // selectUser() calls the create dialog view based on the input of type of user and type of post
                new HomeFeedView().showAllPosts();
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
                new HomeFeedView().showAllPosts();
                break;
            case AUTHOR:
                AuthorUser authorUser = new AuthorUser("mateus", "Mateus", "Uribe");
                // option to go to hoem
                openChoice(authorUser);
                break;
            case PREMIUM:
                NormalUser premiumUser = new NormalUser("sergio", "Sergio", "Conceicao", true);
                new HomeFeedView().showAllPosts();
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
                break;
            case TEXT:
                new CreateTextView(author).createTextDialog();
                break;
            case IMAGE:
                new CreateImageView(author).createImageDialog();
                break;
            case VIDEO:
                new CreateVideoView(author).createVideoDialog();
                break;
        }
    }
}

/*      AuthorUser hugo = new AuthorUser("hugo", "Hugo", "Esteves");
        AuthorUser ze = new AuthorUser("ze", "Jose", "Veiga");

        HomeFeedView homeFeedView = new HomeFeedView();
        AuthorSectionView authorSectionView = new AuthorSectionView();
        //DetailsSectionView detailsSectionView = new DetailsSectionView();

        // Initialize Tweet View
        CreateTweetView createTweetView1 = new CreateTweetView(ze);
        CreateTweetView createTweetView2 = new CreateTweetView(hugo);
        // Initialize Video View
        CreateVideoView createVideoView1 = new CreateVideoView(ze);
        CreateVideoView createVideoView2 = new CreateVideoView(hugo);
        // Initialize Text View
        CreateTextView createTextView1 = new CreateTextView(ze);
        CreateTextView createTextView2 = new CreateTextView(hugo);
        // Initialize Image View
        CreateImageView createImageView1 = new CreateImageView(ze);
        CreateImageView createImageView2 = new CreateImageView(hugo);
 */
       /*  try {
            //createTweetView1.createTweetDialog();
            //createTweetView1.createTweetDialog();
            //createTweetView2.createTweetDialog();
            
            //createVideoView1.createVideoDialog();
            //createVideoView2.createVideoDialog();

            //createTextView1.createTextDialog();
            //createTextView2.createTextDialog();
            //createImageView1.createImageDialog();
            //createImageView2.createImageDialog();

            //homeFeedView.showAllPosts();
            //authorSectionView.showAllAuthorPosts(ze);

            
        } catch (NullPointerException e) {
            System.out.println("Please enter a valid post");
        } */
