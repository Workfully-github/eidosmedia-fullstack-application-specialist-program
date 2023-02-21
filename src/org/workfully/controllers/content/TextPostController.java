package org.workfully.controllers.content;

import org.workfully.Bootstrap;
import org.workfully.models.content.TextPost;
import org.workfully.models.users.Author;
import org.workfully.utilities.facadeDP.ValidateUserInputUtils;

public class TextPostController {

    private TextPost textPostModel; // To be used in order to retrieve POJO from DB later

    public TextPostController() {
    }

    /*
     * To be used when DB is ready
     */
    public TextPostController(TextPost textPostModel) {
        this.textPostModel = textPostModel;
    }

    /*
     * Creates TextPost
     * Saves it in Author Content Log to be used in Author Section
     * Saves it to Global Content Map Controller
     */
    public TextPost createTextPost(Author authorModel, String message, String coverImgURL, boolean premium) throws Exception {
        textPostModel = new TextPost(authorModel, ValidateUserInputUtils.validateMessage(message),
                ValidateUserInputUtils.validateURL(coverImgURL), premium);
        authorModel.getContentLog().add(textPostModel);
        Bootstrap.getGlobalContentMapController().addAuthorContentToGlobalContentMap(authorModel, textPostModel);
        return textPostModel;
    }

}
