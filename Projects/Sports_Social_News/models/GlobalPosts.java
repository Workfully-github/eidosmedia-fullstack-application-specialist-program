package Projects.Sports_Social_News.models;

import java.util.ArrayList;
import java.util.HashMap;

import Projects.Sports_Social_News.models.posts.Post;
import Projects.Sports_Social_News.models.users.AuthorUser;

public class GlobalPosts {
    
    public static HashMap<AuthorUser,ArrayList<Post>> globalPosts;

    public static HashMap<AuthorUser, ArrayList<Post>> getGlobalPosts() {
        return globalPosts;
    }

    public static void addPostToGlobalPosts(AuthorUser author, Post post) {
        if(globalPosts.get(author) == null) {
            globalPosts.put(author, new ArrayList<>());
        }

        globalPosts.get(author).add(post);
    }

    public static void updatePostToGlobalPosts(AuthorUser author, Post post) {
        int index = globalPosts.get(author).indexOf(post);
        
        globalPosts.get(author).add(index, post);
    }

    public static void deletePostToGlobalPosts(AuthorUser author, Post post) {
        int index = globalPosts.get(author).indexOf(post);

        globalPosts.get(author).remove(index);
    }
}
