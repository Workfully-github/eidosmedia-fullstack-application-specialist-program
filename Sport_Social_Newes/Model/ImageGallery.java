package Model;

public class ImageGallery extends Content {
    private String imageGallery;
    private int textContentLimit;
    
    public ImageGallery (Author author, String textContent, String imageGallery){
        super(author, textContent);
                this.textContentLimit = 280;
        this.imageGallery = imageGallery;
    }
}
