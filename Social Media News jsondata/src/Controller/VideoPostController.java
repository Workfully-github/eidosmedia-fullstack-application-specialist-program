package Controller;

import java.util.List;

import Models.Abstract.User;
import Models.Content.VideoPost;
import Models.User.Author;

public class VideoPostController {
    
    public static void displayVideo(VideoPost videoPost){
        System.out.println(videoPost.toString());
    }
    public static void displayPremiumVideoForFreeUser(VideoPost videoPost){
        System.out.println(videoPost.toStringFor280());
        if (videoPost.isPremium()) {
            System.out.println("This is a Premium video Post with 280 char limit");
        }
    }

    public static void displayAll(List<VideoPost> videoPostList){
        System.out.println("#################### Feed Section #####################");
        for (VideoPost post : videoPostList) {
            VideoPostController.displayVideo(post);
            System.out.println();
        }
    }

    public static void displayAuthorSection(Author author, List<VideoPost> videoPostList){
        System.out.println("####################User Section#####################");
        for (VideoPost post : videoPostList) {
            if (post.getAuthor().equals(author)) {
                displayVideo(post);
                System.out.println();
            }
        }
    }

    public static void UserShowvideoPost(User user, List<VideoPost> videoPostList){
        System.out.println("####################Feed Section By User#####################");
        for (VideoPost post : videoPostList) {
            if(!post.isPremium || user.isPremium()){
                VideoPostController.displayVideo(post);
                System.out.println();
            }
            else{
                VideoPostController.displayPremiumVideoForFreeUser(post);
                System.out.println();
            }
            
        }
        
    }
}
