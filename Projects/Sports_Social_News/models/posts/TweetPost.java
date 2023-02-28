package Projects.Sports_Social_News.models.posts;

import org.json.JSONArray;

import Projects.Sports_Social_News.models.users.AuthorUser;

public class TweetPost extends Post {
    
    private String post;
    private JSONArray array;

    public TweetPost(String publicationDate, String sport, AuthorUser author, String post) {
        super(publicationDate, sport, author);
        this.post = post;
    }
    
    public TweetPost(String publicationDate, AuthorUser author, String post) {
        super(publicationDate, author);
        this.post = post;
    }
    
    public TweetPost(JSONArray jsonArray) {
        super(jsonArray);
        post = parsePost(array);
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public AuthorUser getTweetAuthor() {
        return getAuthor();
    }

    private String parsePost(JSONArray array) {
        String post = "";
        for (int i = 0; i < array.length(); i++) {
            post = array.getJSONObject(i).getString("post");
        }
        return post;
    }
}
