package Projects.Sports_Social_News.models.users;

import java.util.ArrayList;

import Projects.Sports_Social_News.models.posts.ImagePost;
import Projects.Sports_Social_News.models.posts.Post;
import Projects.Sports_Social_News.models.posts.TextPost;
import Projects.Sports_Social_News.models.posts.TweetPost;
import Projects.Sports_Social_News.models.posts.VideoPost;

public class AuthorUser extends User {

    private ArrayList<Post> posts = new ArrayList<Post>();

    public AuthorUser(String username, String firstName, String lastName) {
        super(username, firstName, lastName);
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
}
