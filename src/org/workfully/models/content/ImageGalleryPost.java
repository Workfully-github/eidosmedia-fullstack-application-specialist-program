package org.workfully.models.content;

import org.workfully.models.users.Author;

public class ImageGalleryPost extends AbstractContent {

    /* PROPERTIES */
    private String URL;

     /* CONSTRUCTOR */
    public ImageGalleryPost(Author contentAuthor, String textBody, String URL) {
        super(contentAuthor, textBody);
        this.URL = URL;
        //TODO Auto-generated constructor stub
    }

}
