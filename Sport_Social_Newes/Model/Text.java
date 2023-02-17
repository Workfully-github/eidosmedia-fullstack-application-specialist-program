package Model;

public class Text extends Content {

    private Boolean isPremiumContent;
    
    public Text (Author author, Boolean isPremiumContent, String textContent) {
        super(author, textContent);
        this.isPremiumContent = isPremiumContent; 
    }

}
