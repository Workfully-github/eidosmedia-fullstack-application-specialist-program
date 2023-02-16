package org.workfully.users;

import java.util.ArrayList;

import org.workfully.content.AbstractContent;
import org.workfully.users.userInterfaces.CommentContent;
import org.workfully.users.userInterfaces.LikeContent;
import org.workfully.users.userInterfaces.ReadContent;

public abstract class AbstractUser implements ReadContent, CommentContent, LikeContent {

    /* PROPERTIES */
    private static int idCounter = 0;
    private final Integer userId = idCounter++;
    private String userName;
    private ArrayList<AbstractContent> userCommentsLogMap;

    /* CONSTRUCTORS */
    public AbstractUser() {}
    
    public AbstractUser(String userName) {
        this.userName = userName;
    }
    

    /* GETTERS */
    public static int getIdCounter() {
        return idCounter;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public ArrayList<AbstractContent> getUserCommentsLogMap() {
        return userCommentsLogMap;
    }
}
