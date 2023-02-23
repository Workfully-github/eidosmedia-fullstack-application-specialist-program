package org.workfully.models.content;

import org.workfully.models.users.Author;

public class TextPost extends AbstractContent {

    private String coverImgURL;

    public TextPost(Author contentAuthor, String textBody, String coverImgURL, boolean premium) {
        super(contentAuthor, textBody);
        this.coverImgURL = coverImgURL;
        this.premium = premium;
    }

    public String getCoverImgURL() {
        return coverImgURL;
    }

    public void setCoverImgURL(String coverImgURL) {
        this.coverImgURL = coverImgURL;
    }

}
