package org.workfully.models.content;

import org.workfully.models.users.Author;

public class TextPost extends AbstractContent {

    private String coverImgURL;

     /* CONSTRUCTOR */
    public TextPost(Author contentAuthor, String textBody, String coverImgURL) {
        super(contentAuthor, textBody);
        this.coverImgURL = coverImgURL;
    }

    public String getCoverImgURL() {
        return coverImgURL;
    }

    

    

}
