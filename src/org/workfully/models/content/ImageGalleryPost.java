package org.workfully.models.content;

import org.workfully.models.users.Author;

public class ImageGalleryPost extends AbstractContent {

    private String URL;

    public ImageGalleryPost(Author contentAuthor, String textBody, String URL) {
        super(contentAuthor, textBody);
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }
}
