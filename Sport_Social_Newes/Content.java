import java.util.HashMap;

public class Content {
    private Author author;
    private Boolean isPremiumContent;
    private String textContent;
    private int textContentLimit, likes, saves;

    public Content(Author author, Boolean isPremiumContent, String textContent, int textContentLimit){
        this.author = author;
        this.isPremiumContent = isPremiumContent;
        this.textContent = textContent;
        this.textContentLimit = textContentLimit;
        likes = 0;
        saves = 0;
    }
    //SETTERS
    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setIsPremiumContent(Boolean isPremiumContent) {
        this.isPremiumContent = isPremiumContent;
    }

    public void setSaves(int saves) {
        this.saves = saves;
    }

    //GETTERS
    public Author getAuthor() {
        return author;
    }
    public Boolean getIsPremiumContent() {
        return isPremiumContent;
    }
    public int getLikes() {
        return likes;
    }
    public int getSaves() {
        return saves;
    }
    public String getTextContent() {
        return textContent;
    }

}
