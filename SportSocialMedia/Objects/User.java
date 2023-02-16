package SportSocialMedia.Objects;

import java.util.ArrayList;

public abstract class User {
    protected String name;
    protected String id;
    protected ArrayList<SportNew> favouritesNews;

    public void read(SportNew news){
        //to do a print here
    }
    public void comment(SportNew news){
        //to do a comment here
    }

    public void like(SportNew news){
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
    public ArrayList<SportNew> getFavouritesNews() {
        return favouritesNews;
    }
    public void setFavouritesNews(ArrayList<SportNew> favouritesNews) {
        this.favouritesNews = favouritesNews;
    }
    public void addFavouritesNews(SportNew New) {
        this.favouritesNews.add(New);
    }

    

}
