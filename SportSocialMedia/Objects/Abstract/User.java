package SportSocialMedia.Objects.Abstract;

import java.util.ArrayList;

import SportSocialMedia.Objects.Content.Content;

public abstract class User {
    protected String name;
    protected String id;
    protected ArrayList<Content> favouritesNews = new ArrayList<>();

    public void read(Content news){
        //to do a print here
    }
    public void comment(Content news){
        //to do a comment here
    }

    public void like(Content news){
        //to do a print here
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public ArrayList<Content> getFavouritesNews() {
        return favouritesNews;
    }
    public void setFavouritesNews(ArrayList<Content> favouritesNews) {
        this.favouritesNews = favouritesNews;
    }
    public void addFavouritesNews(Content New) {
        this.favouritesNews.add(New);
    }

}
