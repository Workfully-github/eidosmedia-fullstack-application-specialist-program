package SportSocialMedia.Objects.Content;

import SportSocialMedia.Objects.User.Author;

public class VideoPost extends Content {

    protected String video = "";
    protected String descriptionText = "";
    private static final int MAX_CHARACTERS = 280;

    public VideoPost(String postName, Author author) {
        super(postName, author);
    }

    public void updateVideoPost(String video, String descriptionText){
        this.video = video;
        if(descriptionText == null || descriptionText.length() > MAX_CHARACTERS){
            throw new IllegalArgumentException("Invalid tweet text");
        }
        this.descriptionText = descriptionText;
    }

    @Override
    public String toString() {
        return "VideoPost [video=" + video + ", descriptionText=" + descriptionText + "]" + 
        this.toStringContent();
    }

    
    
}
