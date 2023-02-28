import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import Controller.FeedControllers.FeedController;
import View.AppStarter;

public class App {
    public static void main(String[] args) throws MalformedURLException {

        String url = "http://localhost:4000/";
        try {
            URL contentUrl = new URL(url);
            FeedController.parseContentJson(FeedController.getContentFromJson(contentUrl));
            AppStarter.takeOff();
            
        } catch (MalformedURLException e) {
            System.out.print(e.getMessage());
        }
    }
}
