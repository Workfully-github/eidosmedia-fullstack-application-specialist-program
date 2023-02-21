package org.workfully.models.content;

import org.workfully.models.users.Author;

public class TextPost extends AbstractContent {

    private String coverImgURL;

     /* CONSTRUCTOR */
    public TextPost(Author contentAuthor, String textBody, String coverImgURL, boolean premium) {
        super(contentAuthor, textBody);
        this.coverImgURL = coverImgURL;
        this.premium = premium;
    }


    /* GETTERS */
    public String getCoverImgURL() {
        return coverImgURL;
    }

    /* SETTERS */
    public void setCoverImgURL(String coverImgURL) {
        this.coverImgURL = coverImgURL;
    }


    

    
    

    

}
