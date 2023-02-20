package Model.Content;

import Model.Users.Author;

public class Video extends Content {
    private String video;
    private int textContentLimit;
    public Video (Author author, Boolean isContentPremium, String textContent, String video){
        super(author, textContent, isContentPremium);
        this.textContentLimit = 280;
        this.video = video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    
}
