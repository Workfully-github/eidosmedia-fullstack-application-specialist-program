package org.workfully.controllers.users;

import java.util.ArrayList;

import org.workfully.controllers.content.ImageGalleryPostController;
import org.workfully.controllers.content.TextPostController;
import org.workfully.controllers.content.TweetController;
import org.workfully.controllers.content.VideoPostController;
import org.workfully.models.content.AbstractContent;
import org.workfully.models.content.UserComment;
import org.workfully.models.reactions.LikeReaction;
import org.workfully.models.users.Author;
import org.workfully.models.users.userInterfaces.CreateContent;
import org.workfully.utilities.facadeDP.ValidateUserInputUtils;
import org.workfully.view.section.AuthorSection;

public class AuthorController extends AbstractUserController implements CreateContent {

    /* PROPERTIES */
    private Author authorModel;
    private AuthorSection authorSectionView;
    private TweetController tweetController;
    private TextPostController textPostController;
    private VideoPostController videoPostController;
    private ImageGalleryPostController imageGalleryPostController;

    /* CONSTRUCTOR */
    public AuthorController(Author authorModel) {
        this.authorModel = authorModel;
        this.authorSectionView = new AuthorSection(this);
        this.tweetController = new TweetController();
        this.textPostController = new TextPostController();
        this.videoPostController = new VideoPostController();
        this.imageGalleryPostController = new ImageGalleryPostController();
    }

    /* CONTROLLERS */

    public ArrayList<AbstractContent> getContentLog() {
        return authorModel.getContentLog();
    }

    @Override
    public UserComment comment(String comment, AbstractContent content) throws Exception {
        UserComment userComment = new UserComment(authorModel, ValidateUserInputUtils.validateMessage(comment));
        content.getCommentLogMap().add(userComment);
        return userComment;
    }

    @Override
    public void like(AbstractContent content) {
        content.getReactionLogMap().add(new LikeReaction(authorModel));
    }

    @Override
    public void createTweet(String message) throws Exception {
        tweetController.createTweet(this.authorModel, message);
    }

    @Override
    public void createTextPost(String message, String coverImgURL, boolean premium) throws Exception {
        textPostController.createTextPost(this.authorModel, message, coverImgURL, premium);
        
    }

    @Override
    public void createVideoPost(String message, String URL) throws Exception {
        videoPostController.createVideoPost(this.authorModel, message, URL);
    }

    @Override
    public void createImageGalleryPost(String message, String URL) throws Exception {
        imageGalleryPostController.createImageGalleryPost(authorModel, message, URL);
    }

    /* GETTERS */

    public AuthorSection getAuthorSectionView() {
        return authorSectionView;
    }

    public Author getAuthorModel() {
        return authorModel;
    }

}
