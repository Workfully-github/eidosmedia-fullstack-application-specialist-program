
package Model.Users;
import java.util.ArrayList;

import Model.Interactions.Save;

public class User{
    private String name, userName ,emailAdress ;
    private Boolean isPremuim;
    private ArrayList<Save> savedContent;

    public User(String name ,String userName, String emailAdress, Boolean isPremuim){
        this.name = name;
        this.userName = userName;
        this.emailAdress = emailAdress;
        this.isPremuim = isPremuim;
        savedContent = new ArrayList<>();
    }

    //GETTERS & SETTERS
    
    public void setIsPremuim(Boolean isPremuim) {
        this.isPremuim = isPremuim;
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

    public ArrayList<Save> getSavedContent() {
        return savedContent;
    }

    public int getSaveIndex(Save save) {
        return savedContent.indexOf(save);
    }

    public void removeSave(Save save) {
        savedContent.remove(save);
    }

    public void addSave(Save save){
        savedContent.add(save);
    }
} 