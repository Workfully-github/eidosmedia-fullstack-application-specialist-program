package org.workfully.models.users;

import java.util.ArrayList;

import org.workfully.models.content.AbstractContent;
import org.workfully.models.content.UserComment;

public abstract class AbstractUser {

    private static int idCounter = 0;
    private final Integer userId = idCounter++;
    private String userName;
    private ArrayList<UserComment> userCommentsLogMap;
    private ArrayList<AbstractContent> favouriteContentLogMap;

    public AbstractUser() {}
    
    public AbstractUser(String userName) {
        this.userName = userName;
        this.userCommentsLogMap = new ArrayList<>();
        this.favouriteContentLogMap = new ArrayList<>();
    }
    
    public static int getIdCounter() {
        return idCounter;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public ArrayList<UserComment> getUserCommentsLogMap() {
        return userCommentsLogMap;
    }

    public ArrayList<AbstractContent> getFavouriteContentLogMap() {
        return favouriteContentLogMap;
    }

}
