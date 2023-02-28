package Models.User;


import Models.Abstract.User;
import Models.Content.Content;

public class Author extends User {

    public Author(String name,  String id) {
        this.name = name;
        this.id = id;
    }
    public Author(String name,  String id, boolean isPremium) {
        this.name = name;
        this.id = id;
        this.isPremium = isPremium;
    }

    public void postNew(Content news){
        news.setPosted(true);
    }
    
    @Override
    public String toString() {
        return " Name=" + name + ", id=" + id;
    }

}
