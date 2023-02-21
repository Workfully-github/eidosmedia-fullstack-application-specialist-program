package org.workfully.controllers.content;

import org.workfully.Bootstrap;
import org.workfully.models.content.VideoPost;
import org.workfully.models.users.Author;
import org.workfully.utilities.facadeDP.ValidateUserInputUtils;

public class VideoPostController {

    private VideoPost videoPostModel; // To be used in order to retrieve POJO from DB later

    public VideoPostController() {
    }

    /*
     * To be used when DB is ready
     */
    public VideoPostController(VideoPost videoPostModel) {
        this.videoPostModel = videoPostModel;
    }

    /*
     * Creates VideoPost
     * Saves it in Author Content Log to be used in Author Section
     * Saves it to Global Content Map Controller
     */
    public void createVideoPost(Author authorModel, String message, String videoURL)
            throws Exception {
        videoPostModel = new VideoPost(authorModel, ValidateUserInputUtils.validateMessage(message),
                ValidateUserInputUtils.validateURL(videoURL));
        authorModel.getContentLog().add(videoPostModel);
        Bootstrap.getGlobalContentMapController().addAuthorContentToGlobalContentMap(authorModel, videoPostModel);
    }
}