package Model.Content;

import Model.Users.Author;

public class Video extends Content {
    private String videoSrc;
    public Video (Author author, Boolean isContentPremium, String textContent, String videoSrc){
        super(author, textContent, isContentPremium);
        this.videoSrc = videoSrc;
    }

    public void setVideo(String video) {
        this.videoSrc = videoSrc;
    }

    public String getVideoSrc() {
        return videoSrc;
    }
    
}
