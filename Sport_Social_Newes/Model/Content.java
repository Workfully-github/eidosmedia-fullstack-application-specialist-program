package Model;

import java.util.ArrayList;
import java.util.HashMap;

import Model.Interactions.Comment;

public class Content {
    private Author author;
    private String body;
    private ArrayList<User>likes;
    private int saves;
    //for now I'm using a hashmap but I need a data structure to store K,V where Ks can
    //be duplicated
    private ArrayList<Comment> comments;

    public Content(Author author, String body){
        this.author = author;
        this.body = body;
        likes = new ArrayList<>();
        saves = 0;
        comments = new ArrayList<Comment>();
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

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
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

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

}
