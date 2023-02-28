package Models.Content;

import Models.User.Author;

public class TweetPost extends Content {

    protected String text = "";
    private static final int MAX_CHARACTERS = 280;
    
    public TweetPost(String postName, Author author) {
        super(postName, author);
    }

    public TweetPost(String postName, Author author, boolean isPremium) {
        super(postName, author);
        this.isPremium = isPremium;
    }

    public TweetPost(String postName, String body, Author author, boolean isPremium) {
        super(postName, author);
        this.isPremium = isPremium;
        updateTweetPostText(body);
    }
    
    public void updateTweetPostText(String text){
        if(text == null || text.length() > MAX_CHARACTERS){
            throw new IllegalArgumentException("Invalid tweet text");
        }
        this.text = text;
    }
    @Override
    public String toString() {
        return "Title: " + postName + "\n" +
        "Content: " + text + ".\n" +
        this.toStringContent();
    }

    public String toStringFor280() {
        if(text.length() > 280){
            return "Title: " + postName + "\n" +
            "Content: " + text.substring(0,280) + ".\n" +
            this.toStringContent();
        }
        return "Title: " + postName + "\n" +
        "Content: " + text + ".\n" +
        this.toStringContent();
    }
}
