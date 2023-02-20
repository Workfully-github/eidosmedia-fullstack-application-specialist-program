package Controller;

import Model.Content.Content;
import Model.Users.User;

class HandleAuth  {
    private Boolean status;
    public HandleAuth(){
        status = false;
    }
    public Boolean checkUserContentRelationship(User user, Content content){
        if(user.getIsPremuim() == false && content.getIsContentPremium() == true) return status;
        status = true;
        return status;
    }
}
