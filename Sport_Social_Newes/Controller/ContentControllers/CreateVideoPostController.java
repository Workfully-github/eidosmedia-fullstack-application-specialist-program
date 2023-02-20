package Controller.ContentControllers;

import Model.Content.Video;
import Model.Users.Author;

public class CreateVideoPostController {
    public static Video createText(Author author, String body, String video, Boolean isPremiumContent) throws NullPointerException {
        if(body.isEmpty() || body.length() > 280 || video.isEmpty()) return null;
        Video newVideo = new Video(author, isPremiumContent, body, video);
        author.addContent(newVideo);
        return newVideo;
    }
}
