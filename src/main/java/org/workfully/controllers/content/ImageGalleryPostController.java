package org.workfully.controllers.content;

import org.workfully.models.content.ImageGalleryPost;
import org.workfully.models.users.Author;
import org.workfully.utilities.Bootstrap;
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
     * 1- Creates ImageGalleryPost
     * 2 - Saves it in Author Content Log to be used in Author Section
     * 3 - Saves it to Global Content Map Controller
     */
    public ImageGalleryPost createImageGalleryPost(Author authorModel, String message, String imageUrls)
            throws Exception {
        imageGalleryPostModel = new ImageGalleryPost(authorModel, ValidateUserInputUtils.validateMessage(message),
                ValidateUserInputUtils.validateURL(imageUrls));
        authorModel.getContentLog().add(imageGalleryPostModel);
        Bootstrap.getGlobalContentMapController().addAuthorContentToGlobalContentMap(authorModel,
                imageGalleryPostModel);
        return imageGalleryPostModel;
    }
}