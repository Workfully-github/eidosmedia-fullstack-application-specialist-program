package org.workfully.controllers.users;

import java.util.ArrayList;

import org.workfully.models.content.AbstractContent;
import org.workfully.models.content.ImageGalleryPost;
import org.workfully.models.content.TextPost;
import org.workfully.models.content.Tweet;
import org.workfully.models.content.VideoPost;
import org.workfully.models.users.Author;
import org.workfully.models.users.userInterfaces.CreateContent;
import org.workfully.utilities.strategyDP.ValidateUserInput;
import org.workfully.view.section.AuthorSection;

public class AuthorController extends AbstractUserController implements CreateContent{

    /* PROPERTIES */
    private Author authorModel;
    private AuthorSection authorSectionView;
    

    /* CONSTRUCTOR */
    public AuthorController(Author authorModel) {
        this.authorModel = authorModel;
        this.authorSectionView = new AuthorSection(this);
    }

    /* CONTROLLERS */

    public ArrayList<AbstractContent> getContentLog(){
        return authorModel.getContentLog();
    }

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
    public Tweet createTweet(String message) throws Exception {
        Tweet tweet = new Tweet(authorModel, ValidateUserInput.validateTweet(message));
        authorModel.getContentLog().add(tweet);
        return tweet;
    }

    @Override
    public TextPost createTextPost(String message, String coverImgURL) throws Exception {
        TextPost textPost = new TextPost(authorModel, ValidateUserInput.validateMessage(message), ValidateUserInput.validateURL(coverImgURL));
        authorModel.getContentLog().add(textPost);
        // TODO needs more validation
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


    
    


}
