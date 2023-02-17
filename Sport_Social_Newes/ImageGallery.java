public class ImageGallery extends Content {
    private String imageGallery;
    
    public ImageGallery (Author author, Boolean isPremiumContent, String textContent, int textContentLimit, String imageGallery){
        super(author, isPremiumContent, textContent, 280);
        this.imageGallery = imageGallery;
    }
}
