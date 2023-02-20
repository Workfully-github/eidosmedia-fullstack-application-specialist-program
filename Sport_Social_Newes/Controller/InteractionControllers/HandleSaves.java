package Controller.InteractionControllers;

import Model.Interactions.Save;

public class HandleSaves {
   
    public void save(Save save){
        //Check user/content status
        if(save.getUser().getIsPremuim() == false && save.getContent().getIsContentPremium() == true) System.out.println("you can't Interact on this post");
        
        //check if the user already saved the post
        int SaveIndex = save.getUser().getSaveIndex(save); 
        if(SaveIndex > -1) {save.getUser().removeSave(save); System.out.println("You Unsaved " + save.getContent().getAuthor().getUserName() + "'s post");}

        save.getUser().addSave(save);
        System.out.println("You saved " + save.getContent().getAuthor().getUserName() + "'s post");
    }
}
