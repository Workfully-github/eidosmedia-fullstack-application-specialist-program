package Models.User;

import Models.Abstract.User;
import Models.Content.Content;

public class BasicUser extends User {

    
    public BasicUser(String name,  String id) {
        this.name = name;
        this.id = id;
    }
    public void read(Content news){
        //to do a print here
    }
    public void comment(Content news){
        //to do a comment here
    }

    public void like(Content news){
        //to do a print here
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", id=" + id + "]";
    }
}
