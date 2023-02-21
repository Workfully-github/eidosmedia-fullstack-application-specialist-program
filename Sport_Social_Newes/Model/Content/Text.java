package Model.Content;

import Model.Users.Author;

public class Text extends Content {

    private Boolean isPremiumContent;
    String coverImageSrc;
    
    public Text (Author author, Boolean isPremiumContent, String textContent, String coverImageSrc) {
        super(author, textContent, isPremiumContent);
        this.isPremiumContent = isPremiumContent; 
        this.coverImageSrc = coverImageSrc;
    }

    public String getCoverImageSrc() {
        return coverImageSrc;
    }

}
