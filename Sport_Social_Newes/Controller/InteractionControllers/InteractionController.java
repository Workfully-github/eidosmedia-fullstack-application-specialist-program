package Controller.InteractionControllers;

import Model.Content.Content;
import Model.Interactions.Like;
import Model.Interactions.Save;
import Model.Users.User;

public class InteractionController {
    HandleLikes handleLikes = new HandleLikes();
    HandleSaves handleSaves = new HandleSaves();
    HandleComments handleComments = new HandleComments();
    public void interact(int option, Content content, User user) {
        
    }
}
