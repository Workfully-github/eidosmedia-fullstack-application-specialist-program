package models.contents;

import models.users.AuthorUser;

import java.util.ArrayList;

public class GalleryContent extends Content {

    ArrayList<String> images;
    public GalleryContent(AuthorUser authorUser, String title,ArrayList<String> images) {
        super(authorUser, title);
        this.images = images;
    }


}
