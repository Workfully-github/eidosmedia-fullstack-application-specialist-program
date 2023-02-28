package Projects.Sports_Social_News.models.users;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import Projects.Sports_Social_News.models.posts.Post;

public class AuthorUser extends User {

    private ArrayList<Post> posts = new ArrayList<Post>();
    private JSONObject json;
    private String username;
    private String firstName;
    private String lastName;

    public AuthorUser(String username, String firstName, String lastName) {
        super(username, firstName, lastName);
    }

    public AuthorUser(JSONObject json) {
        super(json);
        username = json.getString("username");
        firstName = json.getString("firstName");
        lastName = json.getString("lastName");
    }

    /* private String parseUsername(JSONArray array) {
        String username = "";
        for (int i = 0; i < array.length(); i++) {
            username = array.getJSONObject(i).getJSONObject("author").getString("username");
        }
        return username;
    }

    private String parseFirstName(JSONArray array) {
        String username = "";
        for (int i = 0; i < array.length(); i++) {
            username = array.getJSONObject(i).getJSONObject("author").getString("firstName");
        }
        return username;
    }

    private String parseLastName(JSONArray array) {
        String username = "";
        for (int i = 0; i < array.length(); i++) {
            username = array.getJSONObject(i).getJSONObject("author").getString("lastName");
        }
        return username;
    } */

    public static AuthorUser getJsonUser(JSONObject obj) {

        AuthorUser author = new AuthorUser(obj.getString("username"), obj.getString("username"),obj.getString("username"));
        return author;
    }

    public String getDisplayName() {
        return getName();
    }

    // Get posts array
    public ArrayList<Post> getPosts() {
        return posts;
    }

    // get just one post
    public Post getPost(int index) {
        return posts.get(index);
    }
    
    // set all posts
    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    // add a single post to the array
    public void addPost(Post post) {
        posts.add(post);
    }

    public void updatePost(Post post, int index) {
        posts.add(index, post);
    }

    public void removePost(int index) {
        posts.remove(index);
    }
}
