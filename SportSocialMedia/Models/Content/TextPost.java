package SportSocialMedia.Models.Content;

import SportSocialMedia.Models.User.Author;

public class TextPost extends Content {
    
    protected String coverImage = "";
    protected String text = "";

    public TextPost(String postName, Author author) {
        super(postName, author);
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

}
