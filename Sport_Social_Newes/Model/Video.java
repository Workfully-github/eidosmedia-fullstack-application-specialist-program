package Model;
public class Video extends Content {
    private String video;
    private int textContentLimit;
    public Video (Author author, String textContent, String video){
        super(author, textContent);
        this.textContentLimit = 280;
        this.video = video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    
}
