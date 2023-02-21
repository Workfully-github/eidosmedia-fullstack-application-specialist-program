package Model;

import java.util.ArrayList;

import Model.Content.Content;

public class Feed {
    private static ArrayList<Content> feed = new ArrayList<Content>();
    

    public static void addContenttoFeed(Content post) {
        feed.add(post);
    }

    public static void setFeed(ArrayList<Content> newFeed) {
        feed = newFeed;
    }
    
    public static ArrayList<Content> getFeed() {
        //DISPLAY ALL FEED ONE BY ONE
        return feed;
    }
}
