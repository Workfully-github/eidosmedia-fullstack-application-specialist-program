package org.workfully.controllers.content;

import org.workfully.Bootstrap;
import org.workfully.models.content.ImageGalleryPost;
import org.workfully.models.users.Author;
import org.workfully.utilities.facadeDP.ValidateUserInputUtils;

public class ImageGalleryPostController {

    private ImageGalleryPost imageGalleryPostModel; // To be used in order to retrieve POJO from DB later

    public ImageGalleryPostController() {
    }

    /*
     * To be used when DB is ready
     */
    public ImageGalleryPostController(ImageGalleryPost imageGalleryPostModel) {
        this.imageGalleryPostModel = imageGalleryPostModel;
    }

    /*
     * Creates ImageGalleryPost
     * Saves it in Author Content Log to be used in Author Section
     * Saves it to Global Content Map Controller
     */
    public void createImageGalleryPost(Author authorModel, String message, String imageUrls) throws Exception {
        imageGalleryPostModel = new ImageGalleryPost(authorModel, ValidateUserInputUtils.validateMessage(message),
                ValidateUserInputUtils.validateURL(imageUrls));
        authorModel.getContentLog().add(imageGalleryPostModel);
        Bootstrap.getGlobalContentMapController().addAuthorContentToGlobalContentMap(authorModel,
                imageGalleryPostModel);
    }
}