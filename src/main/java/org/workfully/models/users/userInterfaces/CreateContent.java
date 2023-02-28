package org.workfully.models.users.userInterfaces;

import org.workfully.models.content.ImageGalleryPost;
import org.workfully.models.content.TextPost;
import org.workfully.models.content.Tweet;
import org.workfully.models.content.VideoPost;

public interface CreateContent {

    Tweet createTweet(String message) throws Exception;

    TextPost createTextPost(String message, String coverImgURL, boolean premium) throws Exception;

    VideoPost createVideoPost(String message, String URL) throws Exception;

    ImageGalleryPost createImageGalleryPost(String message, String URL) throws Exception;
}
