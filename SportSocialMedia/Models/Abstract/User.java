package SportSocialMedia.Models.Abstract;

import java.util.ArrayList;

import SportSocialMedia.Models.Content.Content;

public abstract class User {
    protected String name;
    protected String id;
    protected ArrayList<Content> favouritesNews = new ArrayList<>();
    protected boolean isPremium = false;

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
    public boolean isPremium() {
        return isPremium;
    }
    public void setPremium(boolean isPremium) {
        this.isPremium = isPremium;
    }

}
