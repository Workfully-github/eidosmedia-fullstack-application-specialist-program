package SportSocialMedia.Objects.Content;

import SportSocialMedia.Objects.User.Author;

public class TextPost extends Content {
    
    protected String coverImage = "";
    protected String text = "";

    public TextPost(String postName, Author author) {
        super(postName, author);
    }

    public void updateTextPost(String coverImage, String text){
        this.coverImage = coverImage;
        this.text = text;
    }

    @Override
    public String toString() {
        return "TextPost [coverImage=" + coverImage + ", \ntext=" + text + "]\n" +
        this.toStringContent();
    }

}
