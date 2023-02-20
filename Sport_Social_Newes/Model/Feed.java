package Model;

import java.util.ArrayList;

import Model.Content.Content;

public class Feed {
    ArrayList<Content> feed;
    public Feed () {
        feed = new ArrayList<>();
    }

    public void setFeed(Content post) {
        feed.add(post);
    }

    public ArrayList<Content> getFeed() {
        //DISPLAY ALL FEED ONE BY ONE
        return feed;
    }
}
