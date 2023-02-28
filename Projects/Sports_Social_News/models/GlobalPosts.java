package Projects.Sports_Social_News.models;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONString;

import Projects.Sports_Social_News.models.posts.Post;
import Projects.Sports_Social_News.models.users.AuthorUser;

public class GlobalPosts {
    
    public static HashMap<AuthorUser,ArrayList<Post>> globalPosts = new HashMap<AuthorUser,ArrayList<Post>>();

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

    public static String hashMapToString() {
        String jsonString = "";
        jsonString += "{";

        for (HashMap.Entry<AuthorUser,ArrayList<Post>> set : globalPosts.entrySet()) {

            for (int i = 0; i < set.getValue().size(); i++) {
                jsonString += set.getKey().getDisplayName() + " : " + set.getValue().get(i) + ", ";
            }
        }

        jsonString += "}";

        return jsonString;
    }


}
 