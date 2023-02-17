package Projects.Sports_Social_News;

import java.util.ArrayList;

import Projects.Sports_Social_News.models.posts.Post;

public class Section {
    
    private String type;
    private ArrayList<Post> posts;

    public Section(String type, ArrayList<Post> posts) {
        this.type = type;
        this.posts = posts;
    }

    public ArrayList<Post> getPosts() {
        return new ArrayList<Post>();
    }
}
