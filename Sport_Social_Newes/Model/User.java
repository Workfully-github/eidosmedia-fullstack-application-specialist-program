
package Model;
import java.util.ArrayList;

public class User{
    private String name, userName ,emailAdress ;
    private Boolean isPremuim;
    private ArrayList<Content> savedContent;

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

    public ArrayList<Content> getSavedContent() {
        return savedContent;
    }
} 