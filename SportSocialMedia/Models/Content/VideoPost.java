package SportSocialMedia.Models.Content;

import SportSocialMedia.Models.User.Author;

public class VideoPost extends Content {

    protected String video = "";
    protected String descriptionText = "";
    private static final int MAX_CHARACTERS = 280;

    public VideoPost(String postName, Author author) {
        super(postName, author);
    }

    public void updateVideoAndDescription(String video, String descriptionText){
        this.video = video;
        if(descriptionText == null || descriptionText.length() > MAX_CHARACTERS){
            throw new IllegalArgumentException("Invalid tweet text");
        }
        this.descriptionText = descriptionText;
    }

    @Override
    public String toString() {
        return "Title: " + postName + "\n" +
        "Video content: " + video + ".\n" +
        ", descriptionText=" + descriptionText + ";" +
        this.toStringContent();
    }

    
    
}
