package org.workfully.models.users.userInterfaces;

public interface CreateContent {

    void createTweet(String message) throws Exception;

    void createTextPost(String message, String coverImgURL, boolean premium) throws Exception;

    void createVideoPost(String message, String URL) throws Exception;

    void createImageGalleryPost(String message, String URL) throws Exception;
}
