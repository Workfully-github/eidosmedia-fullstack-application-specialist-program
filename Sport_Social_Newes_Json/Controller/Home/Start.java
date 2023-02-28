package Controller.Home;

import java.util.ArrayList;

import Controller.ContentControllers.CreateContentController;
import Controller.FeedControllers.FeedController;
import Controller.UsersControllers.AuthorController;
import Model.Feed;
import Model.Content.Content;
import Model.Content.ImageGallery;
import Model.Content.Text;
import Model.Content.Tweet;
import Model.Users.Author;
import Model.Users.User;

public class Start {
    public static void generateSomeData(){
        Author rahmani = new Author("Abderraouf Rahmani", "Rahmani", "sdf@sdf.com", false);
        Author amine = new Author("Amine", "Amine", "sdf@sdf.com", true);
    
        User hugo = new User("Hugo", "Hugo", "Hugo@ff.com", true);
        User Ricardo = new User("Ricardo", "Ricardo", "Hugo@ff.com", false);
    
        Tweet abduTweet = new Tweet(rahmani, "Yo! Hello World!", true);
        Tweet amineTweet = new Tweet(amine, "write less code", false);
        ImageGallery amineImageGallery = new ImageGallery(amine, false, "Imageeeeeeeeeeeeeeeee", new ArrayList<String>());
        Text blogPost = new Text(amine, true, "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk kkkkkkkkkkkkkkkkkkkkkkkkkggggggggggggggggggggggggggggggggg gggggggggggggggggggggggggggggggggggggggggg ggggggggggggggggggggggggggggggggggggggggggggggggggg tttttttttttttttttttttt tttttttttttttttttttttttttttttttttttttttttttt ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt", "sdfgsd");
        ArrayList<Content> storedContent = new ArrayList<Content>();
        
        AuthorController authorController = new AuthorController();
        CreateContentController.pushContent(abduTweet);
        CreateContentController.pushContent(amineTweet);
        CreateContentController.pushContent(amineImageGallery);
        CreateContentController.pushContent(blogPost);
        
        storedContent.add(abduTweet);
        storedContent.add(amineTweet);
        storedContent.add(amineImageGallery);
        storedContent.add(blogPost);

        FeedController.createFeedPage(storedContent);

    }

    public static Author getBasicAuthor(){
        Author abdu = new Author("Abderraouf", "Abdu", "sdf@sdf.com", false);
        return abdu;
    }

    public static User getBasicUser(){
        User abdu = new User("BasicUser", "BasicUser", "sdf", false);
        return abdu;
    }

    public static User getPremiumUser(){
        User abdu = new User("BasicUser", "BasicUser", "sdf", true);
        
        return abdu;
    }

    public static Author getPremiumAuthor(){
        Author abdu = new Author("Abderraouf", "Abdu", "sdf@sdf.com", true);
        return abdu;
    }

}
