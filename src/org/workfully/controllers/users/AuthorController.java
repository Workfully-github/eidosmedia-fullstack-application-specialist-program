package org.workfully.controllers.users;

import java.util.ArrayList;

import org.workfully.Bootstrap;
import org.workfully.models.content.AbstractContent;
import org.workfully.models.content.ImageGalleryPost;
import org.workfully.models.content.TextPost;
import org.workfully.models.content.Tweet;
import org.workfully.models.content.UserComment;
import org.workfully.models.content.VideoPost;
import org.workfully.models.users.Author;
import org.workfully.models.users.userInterfaces.CreateContent;
import org.workfully.utilities.facadeDP.ValidateUserInput;
import org.workfully.view.section.AuthorSection;

public class AuthorController extends AbstractUserController implements CreateContent {

    /* PROPERTIES */
    private Author authorModel;
    private AuthorSection authorSectionView;

    /* CONSTRUCTOR */
    public AuthorController(Author authorModel) {
        this.authorModel = authorModel;
        this.authorSectionView = new AuthorSection(this);
    }

    /* CONTROLLERS */

    public ArrayList<AbstractContent> getContentLog() {
        return authorModel.getContentLog();
    }

    @Override
    public UserComment comment(String comment, AbstractContent content) throws Exception {
        UserComment userComment = new UserComment(authorModel, ValidateUserInput.validateMessage(comment));
        content.getCommentLogMap().add(userComment);
        return userComment;
    }

    @Override
    public void like(AbstractContent content) {
        // TODO Auto-generated method stub

    }

    @Override
    public Tweet createTweet(String message) throws Exception {
        Tweet tweet = new Tweet(authorModel, ValidateUserInput.validateTweet(message));
        authorModel.getContentLog().add(tweet);
        Bootstrap.getGlobalContentMapController().addAuthorContentToGlobalContentMap(authorModel, tweet);
        return tweet;
    }

    @Override
    public TextPost createTextPost(String message, String coverImgURL) throws Exception {
        TextPost textPost = new TextPost(authorModel, ValidateUserInput.validateMessage(message),
        ValidateUserInput.validateURL(coverImgURL));
        authorModel.getContentLog().add(textPost);
        Bootstrap.getGlobalContentMapController().addAuthorContentToGlobalContentMap(authorModel, textPost);
        return textPost;
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

    /* GETTERS */

    public AuthorSection getAuthorSectionView() {
        return authorSectionView;
    }

    public Author getAuthorModel() {
        return authorModel;
    }

}
