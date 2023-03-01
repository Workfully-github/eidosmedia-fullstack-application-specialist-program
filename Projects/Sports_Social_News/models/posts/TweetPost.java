package Projects.Sports_Social_News.models.posts;

import org.json.JSONArray;
import org.json.JSONObject;

import Projects.Sports_Social_News.models.users.AuthorUser;

public class TweetPost extends Post {
    
    private String post;
    private String publicationDate;
    private AuthorUser author;
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
        /* publicationDate = getDate();
        author = getAuthor(); */
    }

    /* private String parsePublicationDate(JSONArray array) {
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
    } */

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
