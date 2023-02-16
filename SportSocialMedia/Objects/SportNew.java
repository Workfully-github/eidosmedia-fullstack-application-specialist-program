package SportSocialMedia.Objects;

import java.util.ArrayList;

import SportSocialMedia.Interfaces.News;

public class SportNew implements News {

    public String postName;
    public ArrayList<Content> contents; 
    public ArrayList<Like> likes; 
    public ArrayList<Comment> comments; 
    public Author author;
    public boolean isPosted = false;

    

    public SportNew(String postName, ArrayList<Content> contents, Author author) {
        this.postName = postName;
        this.contents = contents;
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



    public ArrayList<Content> getContents() {
        return contents;
    }



    public void setContents(ArrayList<Content> contents) {
        this.contents = contents;
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
            str += comments.get(i).toString();
        }
        return str;
    }


    
}
