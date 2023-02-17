package models.contents;

import models.users.AuthorUser;

public class TweetContent extends Content{

    private String body;
    public TweetContent(AuthorUser authorUser, String title,String body) {
        super(authorUser, title);
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
