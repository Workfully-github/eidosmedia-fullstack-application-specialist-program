package org.workfully.models.content;

import org.workfully.models.users.Author;

public class TextPost extends AbstractContent {

    private String coverImgURL;
    private boolean premium;

     /* CONSTRUCTOR */
    public TextPost(Author contentAuthor, String textBody, String coverImgURL) {
        super(contentAuthor, textBody);
        this.coverImgURL = coverImgURL;
    }


    /* GETTERS */
    public String getCoverImgURL() {
        return coverImgURL;
    }

    public boolean isPremium() {
        return premium;
    }

    /* SETTERS */
    public void setCoverImgURL(String coverImgURL) {
        this.coverImgURL = coverImgURL;
    }



    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    

    
    

    

}
