package Projects.Sports_Social_News.models.posts;

import Projects.Sports_Social_News.models.users.AuthorUser;

public class TextPost extends Post {
    
    private String post, coverImage;
    private boolean isFree;

    public TextPost(String publicationDate, String sport, AuthorUser author, String post, String coverImage,  boolean isFree) {
        super(publicationDate, sport, author);
        this.post = post;
        this.coverImage = coverImage;
        this.isFree = isFree;
    }
    
    public TextPost(String publicationDate, AuthorUser author, String post, String coverImage, boolean isFree) {
        super(publicationDate, author);
        this.post = post;
        this.coverImage = coverImage;
        this.isFree = isFree;
    }

    public String getPost() {
        return post;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public boolean getIsFree() {
        return isFree;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

    public AuthorUser getTextAuthor() {
        return getAuthor();
    }
}
