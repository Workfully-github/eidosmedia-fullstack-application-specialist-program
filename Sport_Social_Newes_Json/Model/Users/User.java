
package Model.Users;
import java.util.ArrayList;

import Model.Content.Content;

public class User{
    private String name, userName ,emailAdress ;
    private Boolean isPremuim;
    private ArrayList<Content> savedContent;
    private ArrayList<Content> likedContent;

    public User(String name ,String userName, String emailAdress, Boolean isPremuim){
        this.name = name;
        this.userName = userName;
        this.emailAdress = emailAdress;
        this.isPremuim = isPremuim;
        savedContent = new ArrayList<Content>();
        likedContent = new ArrayList<Content>();
    }

    //GETTERS & SETTERS
    
    public void setIsPremuim(Boolean isPremuim) {
        this.isPremuim = isPremuim;
    }

    public int getLikeIndex(Content content){
       return likedContent.indexOf(content);
    }

    public void addLikedContent(Content content){
        likedContent.add(content);
    }

    public void removeLikedContent(Content content){
        likedContent.remove(likedContent.indexOf(content));
    }

    //Methods
    public Boolean getIsPremuim() {
        return isPremuim;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public ArrayList<Content> getSavedContent() {
        return savedContent;
    }

    public int getSaveIndex(Content content) {
        return savedContent.indexOf(content);
    }

    public void removeSave(Content content) {
        savedContent.remove(savedContent.indexOf(content));
    }

    public void addSavedContent(Content content){
        savedContent.add(content);
    }
} 