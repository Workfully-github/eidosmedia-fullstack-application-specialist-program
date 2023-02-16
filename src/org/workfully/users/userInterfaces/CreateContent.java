package org.workfully.users.userInterfaces;

import org.workfully.content.ImageGalleryPost;
import org.workfully.content.TextPost;
import org.workfully.content.Tweet;
import org.workfully.content.VideoPost;

public interface CreateContent {

    Tweet createTweet(String message);

    TextPost creaTextPost(String message);

    VideoPost createVideoPost(String message, String URL);

    ImageGalleryPost createImageGalleryPost(String message, String URL);
    
}
