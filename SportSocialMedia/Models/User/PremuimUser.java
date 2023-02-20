package SportSocialMedia.Models.User;

import SportSocialMedia.Models.Abstract.User;
import SportSocialMedia.Models.Content.Content;

public class PremuimUser extends User {
    
    public PremuimUser(String name,  String id) {
        this.name = name;
        this.id = id;
    }
    public void read(Content news){
        //to do a print here
    }

    public void seePremuim(Content news){
        //to do a print here
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", id=" + id + "]";
    }
}
