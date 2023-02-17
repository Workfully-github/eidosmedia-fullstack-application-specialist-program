package org.workfully.models.users.userInterfaces;

import org.workfully.models.content.ImageGalleryPost;
import org.workfully.models.content.TextPost;
import org.workfully.models.content.Tweet;
import org.workfully.models.content.VideoPost;

public interface CreateContent {

    Tweet createTweet(String message);

    TextPost creaTextPost(String message);

    VideoPost createVideoPost(String message, String URL);

    ImageGalleryPost createImageGalleryPost(String message, String URL);
    
}
