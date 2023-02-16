package org.workfully.users;

import org.workfully.content.AbstractContent;
import org.workfully.content.ImageGalleryPost;
import org.workfully.content.TextPost;
import org.workfully.content.Tweet;
import org.workfully.content.VideoPost;
import org.workfully.section.AuthorSection;
import org.workfully.users.userInterfaces.CreateContent;

public class Author extends AbstractUser implements CreateContent {

    /* PROPERTIES */
    AuthorSection authorSection;

    /* CONSTRUCTOR */
    public Author() {
        this.authorSection = new AuthorSection(this);
    }

    public Author(String userName) {
        super(userName);
        this.authorSection = new AuthorSection(this);
    }

    /* BEHAVIOUR */
    @Override
    public void read(AbstractContent content) {
        // TODO Auto-generated method stub

    }

    @Override
    public void comment(String comment, AbstractContent content) {
        // TODO Auto-generated method stub

    }

    @Override
    public void like(AbstractContent content) {
        // TODO Auto-generated method stub

    }

    @Override
    public Tweet createTweet(String message) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TextPost creaTextPost(String message) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public VideoPost createVideoPost(String message, String URL) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ImageGalleryPost createImageGalleryPost(String message, String URL) {
        // TODO Auto-generated method stub
        return null;
    }



}
