package Controller;

import java.util.List;

import Models.Abstract.User;
import Models.Content.ImagePost;
import Models.User.Author;

public class ImagePostController {
    
    public static void displayImage(ImagePost imagePost){
        System.out.println(imagePost.toString());
    }

    public static void displayPremiumImageForFreeUser(ImagePost imagePost){
        System.out.println(imagePost.toStringFor280());
        if (imagePost.isPremium()) {
            System.out.println("This is a Premium Image Post with 280 char limit");
        }
    }

    public static void displayAll(List<ImagePost> imagePostList){
        System.out.println("#################### Feed Section #####################");
        for (ImagePost post : imagePostList) {
            ImagePostController.displayImage(post);
            System.out.println();
        }
    }

    public static void displayAuthorSection(Author author, List<ImagePost> imagePostList){
        System.out.println("####################User Section#####################");
        for (ImagePost post : imagePostList) {
            if (post.getAuthor().equals(author)) {
                displayImage(post);
                System.out.println();
            }
        }
    }

    public static void UserShowImagePost(User user, List<ImagePost> imagePostList){
        System.out.println("####################Feed Section By User#####################");
        for (ImagePost post : imagePostList) {
            if(!post.isPremium || user.isPremium()){
                ImagePostController.displayImage(post);
                System.out.println();
            }
            else{
                ImagePostController.displayPremiumImageForFreeUser(post);
                System.out.println();
            }
            
        }
        
    }
}
