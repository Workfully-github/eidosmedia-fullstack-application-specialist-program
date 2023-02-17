package org.workfully.content;

import org.workfully.users.Author;

public class VideoPost extends AbstractContent {

    private String URL;

    /* CONSTRUCTOR */
    public VideoPost(Author contentAuthor, String textBody, String URL) {
        super(contentAuthor, textBody);
        this.URL = URL;
    }

}
