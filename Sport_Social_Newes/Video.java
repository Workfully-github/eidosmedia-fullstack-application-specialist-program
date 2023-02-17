public class Video extends Content {
    private String video;
    public Video (Author author, Boolean isPremiumContent, String textContent, int textContentLimit, String video){
        super(author, isPremiumContent, textContent, 280);
        this.video = video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    
}
