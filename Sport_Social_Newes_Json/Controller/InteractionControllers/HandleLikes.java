package Controller.InteractionControllers;


import Model.Content.Content;
import Model.Users.User;

public class HandleLikes {
    public void like(Content content, User user){

        if(user.getLikeIndex(content) > -1){
            content.removeLike();
            user.removeLikedContent(content);
            System.out.println("You Disliked " + content.getAuthor().getUserName() + "'s post");
            return;
        }
            content.addLike();
            user.addLikedContent(content);
            System.out.println("You Liked " + content.getAuthor().getUserName() + "'s post");
    }


    
}
