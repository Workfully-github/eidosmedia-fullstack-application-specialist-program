package SportSocialMedia.Models.Content;

import SportSocialMedia.Models.User.Author;

public class VideoPost extends Content {

    protected String video = "";
    protected String descriptionText = "";
    private static final int MAX_CHARACTERS = 280;

    public VideoPost(String postName, Author author) {
        super(postName, author);
    }

    public VideoPost(String postName, Author author, boolean isPremium) {
        super(postName, author);
        this.isPremium = isPremium;
    }

    public VideoPost(String postName, String url, String body, Author author, boolean isPremium) {
        super(postName, author);
        this.isPremium = isPremium;
        updateVideoAndDescription(url, body);
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

    public String toStringFor280() {
        if(descriptionText.length() > 280){
            return "Title: " + postName + "\n" +
            "Video content: " + video + ".\n" +
            ", descriptionText=" + descriptionText.substring(0,280) + ";" +
            this.toStringContent();
        }
        return "Title: " + postName + "\n" +
        "Video content: " + video + ".\n" +
        ", descriptionText=" + descriptionText + ";" +
        this.toStringContent();
    }
}
