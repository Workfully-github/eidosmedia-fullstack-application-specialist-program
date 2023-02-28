package Models.Content;

import java.util.ArrayList;

import Models.Comment;
import Models.Like;
import Models.Abstract.User;
import Models.Interfaces.News;
import Models.User.Author;

public class Content implements News {

    public String postName;
    public ArrayList<Like> likes = new ArrayList<>(); 
    public ArrayList<Comment> comments = new ArrayList<>(); 
    public Author author;
    public boolean isPosted = false;
    public boolean isPremium = false;

    public Content(String postName, Author author) {
        this.postName = postName;
        this.author = author;
    }

    @Override
    public void read() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void comment(User user, String comment) {
        // TODO Auto-generated method stub
        Comment commentInstance = new Comment(comment,user);
        this.comments.add(commentInstance);
        
    }

    @Override
    public void like(User user) {
        Like like = new Like(user);
        this.likes.add(like);
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public boolean isPosted() {
        return isPosted;
    }

    public void setPosted(boolean isPosted) {
        this.isPosted = isPosted;
    }

    public ArrayList<Like> getLikes() {
        return likes;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean isPremium) {
        this.isPremium = isPremium;
    }

    public String toStringLikes() {
        return "| "+ likes.size() + " likes";
    }

    public String toStringComments() {
        String str ="\n|  ";
        for(int i=0; i<comments.size();i++){
            str +=i +") ==> " + comments.get(i).toString() + "\n";
        }
        return str;
    }

    public String toStringContent() {
        return "-----------------------------\n" +
         toStringLikes() + ";\n| Comments:" + toStringComments() + ". \n| Author=" + author.toString()
                + "; \n| Is Posted: " + isPosted + ";" +
                "\n| Is Premium: " + isPremium + ";" +
                "\n-----------------------------" ;
    }

    
}
