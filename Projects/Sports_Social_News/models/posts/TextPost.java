package Projects.Sports_Social_News.models.posts;

import org.json.JSONArray;

import Projects.Sports_Social_News.models.users.AuthorUser;

public class TextPost extends Post {
    
    private String post, coverImage;
    private boolean isFree;
    private JSONArray array;

    public TextPost(String publicationDate, String sport, AuthorUser author, String post, String coverImage,  boolean isFree) {
        super(publicationDate, sport, author);
        this.post = post;
        this.coverImage = coverImage;
        this.isFree = isFree;
    }
    
    public TextPost(String publicationDate, AuthorUser author, String post, String coverImage, boolean isFree) {
        super(publicationDate, author);
        this.post = post;
        this.coverImage = coverImage;
        this.isFree = isFree;
    }

    public TextPost(JSONArray jsonArray) {
        super(jsonArray);
        post = parsePost(array);
        coverImage = parseCoverImage(jsonArray);
        isFree = parseIsFree(jsonArray);
    }

    public String getPost() {
        return post;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public boolean getIsFree() {
        return isFree;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

    public AuthorUser getTextAuthor() {
        return getAuthor();
    }

    private String parsePost(JSONArray array) {
        String post = "";
        for (int i = 0; i < array.length(); i++) {
            post = array.getJSONObject(i).getString("post");
        }
        return post;
    }

    private String parseCoverImage(JSONArray array) {
        String cover = "";
        for (int i = 0; i < array.length(); i++) {
            cover = array.getJSONObject(i).getString("coverImage");
        }
        return cover;
    }

    private boolean parseIsFree(JSONArray array) {
        String free = "";
        for (int i = 0; i < array.length(); i++) {
            free = array.getJSONObject(i).getString("isFree");

        }
        if(free.equals("true")) return true;
        else return false;
    }
}
