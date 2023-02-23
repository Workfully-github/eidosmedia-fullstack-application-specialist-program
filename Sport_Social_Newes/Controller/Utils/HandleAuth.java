package Controller.Utils;

import Model.Content.Content;
import Model.Users.User;

public class HandleAuth  {
    public static Boolean checkUserContentRelationship(User user, Content content){

        if(user.getIsPremuim() == false && content.getIsContentPremium() == true && content.getAuthor().getUserName() != user.getUserName()) return false;
        return true;
    }
}
