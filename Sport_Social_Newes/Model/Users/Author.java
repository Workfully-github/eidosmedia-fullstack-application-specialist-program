package Model.Users;
import java.util.ArrayList;

import Model.Content.Content;

public class Author extends User {
    private ArrayList<Content> myContent;

    public Author(String name ,String userName, String emailAdress, Boolean isPremuim){
        super(name, userName, emailAdress, isPremuim);
        
        myContent = new ArrayList<>();
    }

    public void addContent(Content content){
        myContent.add(content);
    }

    public void removeContent(int contentIndex) {

    }

    public ArrayList<Content> getMyContent() {
        return myContent;
    }

}
