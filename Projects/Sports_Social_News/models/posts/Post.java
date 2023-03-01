package Projects.Sports_Social_News.models.posts;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import Projects.Sports_Social_News.models.interactions.Comment;
import Projects.Sports_Social_News.models.interactions.Reaction;
import Projects.Sports_Social_News.models.users.AuthorUser;
import Projects.Sports_Social_News.models.users.User;

public class Post {

    private String publicationDate, sport;
    private AuthorUser author;
    private JSONArray jsonArray;

    private ArrayList<Comment> comments = new ArrayList<Comment>();
    private ArrayList<Reaction> reactions = new ArrayList<Reaction>(); 

    public Post(String publicationDate, String sport, AuthorUser author) {
        this.publicationDate = publicationDate;
        this.sport = sport;
        this.author = author;
    }

    public Post(String publicationDate, AuthorUser author) {
        this.publicationDate = publicationDate;
        this.author = author;
    }

    public Post(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
        publicationDate = parsePublicationDate(jsonArray);
        author = AuthorUser.getJsonUser(parseAuthor(jsonArray));
    }

    private String parsePublicationDate(JSONArray array) {
        String date = "";
        for (int i = 0; i < array.length(); i++) {
            date = array.getJSONObject(i).getString("publicationDate");
        }
        return date;
    }

    private static JSONObject parseAuthor(JSONArray array) {
        JSONObject obj = new JSONObject();
        for (int i = 0; i < array.length(); i++) {
            obj = array.getJSONObject(i).getJSONObject("author");
        }
        return obj;
    }

    public AuthorUser getAuthor() {return author;}

    public String getDate() {return publicationDate;}

    // get the comments
    public ArrayList<Comment> getComments() {return comments;}

    // get the likes
    public ArrayList<Reaction> getReactions() {return reactions;}

    public void setAuthor(AuthorUser author) {this.author = author;}

    public void setDate(String publicationDate) {this.publicationDate = publicationDate;}

    public void setComments(ArrayList<Comment> comments) {this.comments = comments;}

    public void setReactions(ArrayList<Reaction> reactions) {this.reactions = reactions;}

    public void addCommentPost(Comment comment, User user) {
        comments.add(comment);
        // add the comment on the user who did it
        user.addComment(comment);
    }

    public void updateCommentPost(Comment comment, User user) {
        int index = comments.indexOf(comment);
        comments.add(index, comment);
        // update the comment on the user who did it
        user.updateComment(comment);
    }

    public void deleteCommentPost(Comment comment, User user) {
        int index = comments.indexOf(comment);
        comments.remove(index);
        // remove the comment on the user who did it
        user.deleteComment(comment);
    }

    public void addReactionPost(Reaction reaction, User user) {
        reactions.add(reaction);
        // add the reaction on the user who did it
        user.addReaction(reaction);
    }

    public void updateReactionPost(Reaction reaction, User user) {
        int index = reactions.indexOf(reaction);
        reactions.add(index, reaction);
        // update the reaction on the user who did it
        user.updateReaction(reaction);
    }

    public void deleteReactionPost(Reaction reaction, User user) {
        int index = reactions.indexOf(reaction);
        reactions.remove(index);
        // remove the reaction on the user who did it
        user.deleteReaction(reaction);
    }

    public int numberComments() {
        return comments.size();
    }

    public int numberReactions() {
        return reactions.size();
    }
}
