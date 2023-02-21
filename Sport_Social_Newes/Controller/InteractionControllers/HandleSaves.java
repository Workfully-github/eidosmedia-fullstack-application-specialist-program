package Controller.InteractionControllers;

import Model.Content.Content;
import Model.Users.User;

public class HandleSaves {
   
    public void save(Content content, User user){
        
        int SaveIndex = user.getSaveIndex(content); 
        if(SaveIndex > -1) {
            content.removeSave();
            user.removeSave(content);
            System.out.println("You Unsaved " + content.getAuthor().getUserName() + "'s post");
            return;
        }

        content.addSave();
        user.addSavedContent(content);
        System.out.println("You saved " + content.getAuthor().getUserName() + "'s post");
    }
}
