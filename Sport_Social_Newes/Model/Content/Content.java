package Model.Content;

import java.util.ArrayList;

import Model.Interactions.Comment;
import Model.Users.Author;

public class Content {
    private Author author;
    private String body;
    private int likes;
    private int  saves;
    private Boolean isContentPremium;
    private ArrayList<Comment> comments;

    public Content(Author author, String body, Boolean isContentPremium){
        this.author = author;
        this.body = body;
        this.isContentPremium = isContentPremium;
        likes = 0;
        saves = 0;
        comments = new ArrayList<Comment>();
    }
    public void setBody(String body) {
        this.body = body;
    }



    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public Author getAuthor() {
        return author;
    }
   
    public int getLikes() {
        return likes;
    }

    public void addLike(){
        likes++;
    }

    public void removeLike() {
        likes--;
    }

    public void addSave(){
        saves++;
    }

    public void removeSave() {
        saves--;
    }

    public int getSavesCount() {
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
