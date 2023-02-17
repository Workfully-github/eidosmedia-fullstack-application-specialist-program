package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Content {
    private Author author;
    private String body;
    private ArrayList<User>likes;
    private int saves;
    private HashMap<User, String> comments;

    public Content(Author author, String body){
        this.author = author;
        this.body = body;
        likes = new ArrayList<>();
        saves = 0;
        comments = new HashMap<User, String>();
    }
    //SETTERS
    public void setBody(String body) {
        this.body = body;
    }

    public void setLikes(User user) {
        likes.add(user);
    }

    public void setSaves(int saves) {
        this.saves = saves;
    }

    public void setComment(User user, String comment) {
        comments.put(user, comment);
    }

    //GETTERS
    public Author getAuthor() {
        return author;
    }
   
    public ArrayList<User> getLikes() {
        return likes;
    }

    public int getSaves() {
        return saves;
    }

    public String getBody() {
        return body;
    }

    public HashMap<User, String> getComments() {
        return comments;
    }

}
