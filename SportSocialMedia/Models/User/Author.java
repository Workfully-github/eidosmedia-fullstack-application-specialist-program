package SportSocialMedia.Models.User;


import SportSocialMedia.Models.Abstract.User;
import SportSocialMedia.Models.Content.Content;

public class Author extends User {

    public Author(String name,  String id) {
        this.name = name;
        this.id = id;
    }

    public void postNew(Content news){
        news.setPosted(true);
    }
    
    @Override
    public String toString() {
        return "User [name=" + name + ", id=" + id + "]";
    }

}
