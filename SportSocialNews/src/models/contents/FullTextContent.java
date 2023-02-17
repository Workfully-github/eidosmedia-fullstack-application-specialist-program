package models.contents;

import models.users.AuthorUser;

public class FullTextContent extends Content{

    private String coverImage;
    public FullTextContent(AuthorUser authorUser, String title,String coverImage) {
        super(authorUser, title);
        this.coverImage = coverImage;
    }
}
