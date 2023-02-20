package Projects.Sports_Social_News.models.posts;

import java.util.ArrayList;
import java.util.HashMap;

import Projects.Sports_Social_News.models.users.AuthorUser;
import Projects.Sports_Social_News.models.users.User;

public class Post {

    private String publicationDate, sport;
    private AuthorUser author;

    //private ArrayList<Comment> comments = new ArrayList<Comment>();
    //private ArrayList<Reaction> reactions = new ArrayList<Reaction>();
    private ArrayList<User> likes = new ArrayList<User>(); 

    public Post(String publicationDate, String sport, AuthorUser author) {
        
        this.publicationDate = publicationDate;
        this.sport = sport;
        this.author = author;
    }

    public Post(String publicationDate, AuthorUser author) {
        
        this.publicationDate = publicationDate;
        this.author = author;
    }

    public AuthorUser getAuthor() {
        return author;
    }

    public String getDate() {
        return publicationDate;
    }

    // list comments
    public void addComment(String comment) {}

    // list of likes
    public void addLike(User like) {}

    // get the comments
    public HashMap<User, String> getComments() {
        return new HashMap<User, String>();
    }

    // get the likes
    public ArrayList<User> getLikes() {
        return new ArrayList<User>();
    }


}
