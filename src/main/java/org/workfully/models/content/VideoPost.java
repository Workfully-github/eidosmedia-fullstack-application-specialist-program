package org.workfully.models.content;

import org.workfully.models.users.Author;

public class VideoPost extends AbstractContent {

    private String URL;

    public VideoPost(Author contentAuthor, String textBody, String URL) {
        super(contentAuthor, textBody);
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }
}
