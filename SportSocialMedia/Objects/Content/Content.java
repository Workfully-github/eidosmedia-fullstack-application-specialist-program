package SportSocialMedia.Objects.Content;

import java.util.ArrayList;

import SportSocialMedia.Interfaces.News;
import SportSocialMedia.Objects.Comment;
import SportSocialMedia.Objects.Like;
import SportSocialMedia.Objects.User.Author;

public class Content implements News {

    public String postName;
    public ArrayList<Like> likes = new ArrayList<>(); 
    public ArrayList<Comment> comments = new ArrayList<>(); 
    public Author author;
    public boolean isPosted = false;

    public Content(String postName, Author author) {
        this.postName = postName;
        this.author = author;
    }

    @Override
    public void read() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void comment() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void like() {
        // TODO Auto-generated method stub
        
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

    public String toStringLikes() {
        return "the number of likes is : " + likes.size();
    }

    public String toStringComments() {
        String str =" ";
        for(int i=0; i<comments.size();i++){
            str +=i +". " + comments.get(i).toString() + "\n";
        }
        return str;
    }

    public String toStringContent() {
        return "PostName=" + postName + "]\n" +
         toStringLikes() + ",\n comments=" + toStringComments() + ", \n Author=" + author.toString()
                + ", isPosted=" + isPosted + "]";
    }

    
}
