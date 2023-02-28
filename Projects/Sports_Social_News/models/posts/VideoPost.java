package Projects.Sports_Social_News.models.posts;

import org.json.JSONArray;

import Projects.Sports_Social_News.models.users.AuthorUser;

public class VideoPost extends Post {
    
    // how to define maxlenght de 280?
    private String description, videoUrl;
    private JSONArray array;

    public VideoPost(String publicationDate, String sport, AuthorUser author, String description, String videoUrl) {
        super(publicationDate, sport, author);
        this.description = description;
        this.videoUrl = videoUrl;
    }
    
    public VideoPost(String publicationDate, AuthorUser author, String description, String videoUrl) {
        super(publicationDate, author);
        this.description = description;
        this.videoUrl = videoUrl;
    }

    public VideoPost(JSONArray jsonArray) {
        super(jsonArray);
        description = parseDescription(array);
        videoUrl = parseVideoUrl(jsonArray);
    }

    public String getDescription() {
        return description;
    }

    public String getVideo() {
        return videoUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVideo(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public AuthorUser getVideoAuthor() {
        return getAuthor();
    }

    private String parseDescription(JSONArray array) {
        String description = "";
        for (int i = 0; i < array.length(); i++) {
            description = array.getJSONObject(i).getString("description");
        }
        return description;
    }

    private String parseVideoUrl(JSONArray array) {
        String videoUrl = "";
        for (int i = 0; i < array.length(); i++) {
            videoUrl = array.getJSONObject(i).getString("videoUrl");
        }
        return videoUrl;
    }
}
