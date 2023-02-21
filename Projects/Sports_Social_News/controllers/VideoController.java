package Projects.Sports_Social_News.controllers;

import Projects.Sports_Social_News.models.GlobalPosts;
import Projects.Sports_Social_News.models.posts.VideoPost;
import Projects.Sports_Social_News.models.users.AuthorUser;

public class VideoController {
    
    public VideoPost createVideoPost(String publicationDate, AuthorUser author, String description, String videoUrl) throws NullPointerException {

        if(description.isEmpty()) return null;
        if(description.length() > 280) return null;
        if(videoUrl.isEmpty()) return null;

        VideoPost video = new VideoPost(publicationDate, author, description, videoUrl);

        author.addPost(video);
        GlobalPosts.addPostToGlobalPosts(author, video);

        return video;
    }

    public VideoPost updateVideoDescription(VideoPost video, String description) throws NullPointerException {

        if(description.isEmpty()) return null;
        if(description.length() > 280) return null;

        int index = video.getVideoAuthor().getPosts().indexOf(video);
        video.setDescription(description);
        
        video.getVideoAuthor().updatePost(video, index);
        GlobalPosts.updatePostToGlobalPosts(video.getVideoAuthor(), video);

        return video;
    }

    public VideoPost updateVideoUrl(VideoPost video, String videoUrl) throws NullPointerException {

        if(videoUrl.isEmpty()) return null;

        int index = video.getVideoAuthor().getPosts().indexOf(video);
        video.setVideo(videoUrl);
        
        video.getVideoAuthor().updatePost(video, index);
        GlobalPosts.updatePostToGlobalPosts(video.getVideoAuthor(), video);

        return video;
    }

    public void deleteVideoPost(VideoPost video) {
        int index = video.getVideoAuthor().getPosts().indexOf(video);
        
        video.getVideoAuthor().removePost(index);
        GlobalPosts.deletePostToGlobalPosts(video.getVideoAuthor(), video);
    }

    public void display(VideoPost video) {
        System.out.println("Description: " + video.getDescription());
        System.out.println("Link: " + video.getVideo());
        System.out.println("By: " + video.getAuthor().getDisplayName());
    }
}
