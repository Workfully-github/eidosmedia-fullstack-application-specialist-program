package Model.Content;

import java.util.ArrayList;
import java.util.HashMap;

import Model.Interactions.Comment;
import Model.Interactions.Like;
import Model.Interactions.Save;
import Model.Users.Author;

public class Content {
    private Author author;
    private String body;
    private ArrayList<Like>likes;
    private ArrayList<Save> saves;
    private Boolean isContentPremium;
    //for now I'm using a ArrayList for the comments, but I need a data structure to store K,V where Ks can
    //be duplicated
    private ArrayList<Comment> comments;

    public Content(Author author, String body, Boolean isContentPremium){
        this.author = author;
        this.body = body;
        this.isContentPremium = isContentPremium;
        likes = new ArrayList<Like>();
        saves = new ArrayList<Save>();
        comments = new ArrayList<Comment>();
    }
    //SETTERS
    public void setBody(String body) {
        this.body = body;
    }

    public void addLike(Like like) {
        likes.add(like);
    }

    public void setSaves(Save save) {
        // this.saves = saves;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    //GETTERS
    public Author getAuthor() {
        return author;
    }
   
    public ArrayList<Like> getLikes() {
        return likes;
    }

    public int getLikeIndex(Like like){
        return likes.indexOf(like);
    }

    public void removeLike(Like like) {
        likes.remove(like);
    }

    public ArrayList<Save> getSaves() {
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

    public Boolean getIsContentPremium() {
        return isContentPremium;
    }

}
