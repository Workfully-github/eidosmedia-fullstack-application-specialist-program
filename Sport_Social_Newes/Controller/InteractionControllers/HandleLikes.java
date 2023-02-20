package Controller.InteractionControllers;


import Model.Content.Content;
import Model.Interactions.Like;

public class HandleLikes {
    public void like(Like like){
        //Check user/content status
        if(like.getUser().getIsPremuim() == false && like.getContent().getIsContentPremium() == true) System.out.println("you can't Interact with this post");

        //check if the user already liked the post
        int likeIndex = like.getContent().getLikeIndex(like); 
        if(likeIndex > -1) {like.getContent().removeLike(like);  System.out.println("You Disliked " + like.getContent().getAuthor().getUserName() + "'s post"); return;}

        like.getContent().addLike(like);
         System.out.println("You Liked " + like.getContent().getAuthor().getUserName() + "'s post");
    }
}
