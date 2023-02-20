package Projects.Sports_Social_News.models.users;

import java.util.ArrayList;

import Projects.Sports_Social_News.models.interactions.Comment;
import Projects.Sports_Social_News.models.interactions.Reaction;
import Projects.Sports_Social_News.models.posts.Post;

public class User {
    
    private String username, firstName, lastName;
    private ArrayList<Post> favoritePosts = new ArrayList<Post> ();
    private ArrayList<Comment> comments = new ArrayList<Comment> ();
    private ArrayList<Reaction> reactions = new ArrayList<Reaction> ();

    public User(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public ArrayList<Post> getFavorites() {
        return favoritePosts;
    }

    public void addFavorite(Post favorite) {
        favoritePosts.add(favorite);
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void updateComment(Comment comment) {
        int index = comments.indexOf(comment);
        comments.add(index, comment);
    }

    public void deleteComment(Comment comment) {
        int index = comments.indexOf(comment);
        comments.remove(index);
    }

    public ArrayList<Reaction> getReactions() {
        return reactions;
    }

    public void addReaction(Reaction reaction) {
        reactions.add(reaction);
    }

    public void updateReaction(Reaction reaction) {
        int index = reactions.indexOf(reaction);
        reactions.add(index, reaction);
    }

    public void deleteReaction(Reaction reaction) {
        int index = reactions.indexOf(reaction);
        reactions.remove(index);
    }
} 