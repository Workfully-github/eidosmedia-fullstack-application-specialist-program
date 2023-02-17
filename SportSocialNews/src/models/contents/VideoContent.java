package models.contents;

import models.users.AuthorUser;

public class VideoContent extends Content{

    private String videoSrc;

    public VideoContent(AuthorUser authorUser, String title, String videoSrc) {
        super(authorUser, title);
        this.videoSrc = videoSrc;
    }
}
