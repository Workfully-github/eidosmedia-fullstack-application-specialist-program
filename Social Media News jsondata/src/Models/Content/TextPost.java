package Models.Content;

import Models.User.Author;

public class TextPost extends Content {
    
    protected String coverImage = "";
    protected String text = "";

    public TextPost(String postName, Author author) {
        super(postName, author);
    }

    public TextPost(String postName, Author author, boolean isPremium) {
        super(postName, author);
        this.isPremium = isPremium;
    }

    public TextPost(String postName,String url, String body, Author author, boolean isPremium) {
        super(postName, author);
        this.isPremium = isPremium;
        updateCoverImageAndText(url, body);
    }

    public void updateCoverImageAndText(String coverImage, String text){
        this.coverImage = coverImage;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Title: " + postName + "\n" +
        "Content: " + text + ".\n" +
        "Cover Image: " + coverImage + ".\n" +
        this.toStringContent();
    }

    public String toStringFor280() {
        if(text.length() > 280){
            return "Title: " + postName + "\n" +
            "Content: " + text.substring(0,280) + ".\n" +
            "Cover Image: " + coverImage + ".\n" +
            this.toStringContent();
        }

        return "Title: " + postName + "\n" +
        "Content: " + text + ".\n" +
        "Cover Image: " + coverImage + ".\n" +
        this.toStringContent();
    }
}
