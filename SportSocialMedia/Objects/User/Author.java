package SportSocialMedia.Objects.User;


import SportSocialMedia.Objects.Abstract.User;
import SportSocialMedia.Objects.Content.Content;

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
