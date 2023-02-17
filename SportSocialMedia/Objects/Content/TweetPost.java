package SportSocialMedia.Objects.Content;

import SportSocialMedia.Objects.User.Author;

public class TweetPost extends Content {

    protected String text = "";
    private static final int MAX_CHARACTERS = 280;
    
    public TweetPost(String postName, Author author) {
        super(postName, author);
    }
    
    public void updateTweetPost(String text){
        if(text == null || text.length() > MAX_CHARACTERS){
            throw new IllegalArgumentException("Invalid tweet text");
        }
        this.text = text;
    }
    @Override
    public String toString() {
        return "TextPost [text=" + text + "]\n" +
        this.toStringContent();
    }
}
