package org.workfully.controllers.users;

import java.util.ArrayList;

import org.workfully.controllers.content.ImageGalleryPostController;
import org.workfully.controllers.content.TextPostController;
import org.workfully.controllers.content.TweetController;
import org.workfully.controllers.content.VideoPostController;
import org.workfully.models.content.AbstractContent;
import org.workfully.models.content.ImageGalleryPost;
import org.workfully.models.content.TextPost;
import org.workfully.models.content.Tweet;
import org.workfully.models.content.VideoPost;
import org.workfully.models.users.Author;
import org.workfully.models.users.userInterfaces.CreateContent;
import org.workfully.view.section.AuthorSection;

public class AuthorController extends AbstractUserController implements CreateContent {

    private AuthorSection authorSectionView;
    private TweetController tweetController;
    private TextPostController textPostController;
    private VideoPostController videoPostController;
    private ImageGalleryPostController imageGalleryPostController;

    public AuthorController(Author authorModel) {
        super(authorModel);
        this.authorSectionView = new AuthorSection(this);
        this.tweetController = new TweetController();
        this.textPostController = new TextPostController();
        this.videoPostController = new VideoPostController();
        this.imageGalleryPostController = new ImageGalleryPostController();
    }

    /* CONTROLLERS */

    @Override
    public Tweet createTweet(String message) throws Exception {
        return tweetController.createTweet(((Author) this.userModel), message);
    }

    @Override
    public TextPost createTextPost(String message, String coverImgURL, boolean premium) throws Exception {
        return textPostController.createTextPost(((Author) this.userModel), message, coverImgURL, premium);
    }

    @Override
    public VideoPost createVideoPost(String message, String URL) throws Exception {
        return videoPostController.createVideoPost(((Author) this.userModel), message, URL);
    }

    @Override
    public ImageGalleryPost createImageGalleryPost(String message, String URL) throws Exception {
        return imageGalleryPostController.createImageGalleryPost(((Author) this.userModel), message, URL);
    }

    public AuthorSection getAuthorSectionView() {
        return authorSectionView;
    }

    public Author getAuthorModel() {
        return ((Author) this.userModel);
    }

    public ArrayList<AbstractContent> getContentLog() {
        return ((Author) this.userModel).getContentLog();
    }
}
