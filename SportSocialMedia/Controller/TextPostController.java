package SportSocialMedia.Controller;

import java.util.List;

import SportSocialMedia.Models.Abstract.User;
import SportSocialMedia.Models.Content.TextPost;
import SportSocialMedia.Models.User.Author;

public class TextPostController {
    
    public static void displayText(TextPost textPost){
        System.out.println(textPost.toString());
    }


    public static void displayPremiumTextForFreeUser(TextPost text){
        System.out.println(text.toStringFor280());
        if (text.isPremium()) {
            System.out.println("This is a Premium Post with 280 char limit");
        }
    }

    public static void displayAll(List<TextPost> textPostList){
        System.out.println("####################Feed Section#####################");
        for (TextPost post : textPostList) {
            TextPostController.displayText(post);
            System.out.println();
        }
    }

    public static void displayAuthorSection(Author author, List<TextPost> textPostList){
        System.out.println("####################User Section#####################");
        for (TextPost post : textPostList) {
            if (post.getAuthor().equals(author)) {
                displayText(post);
                System.out.println();
            }
        }
    }

    public static void UserShowTextPost(User user, List<TextPost> textPostList){
        System.out.println("####################Feed Section By User#####################");
        for (TextPost post : textPostList) {
            if(!post.isPremium || user.isPremium()){
                TextPostController.displayText(post);
                System.out.println();
            }
            else{
                TextPostController.displayPremiumTextForFreeUser(post);
                System.out.println();
            }
            
        }
        
    }
}
