package Model;
import java.util.ArrayList;

public class Author extends User {
    private ArrayList<Content> myContent;

    public Author(String name ,String userName, String emailAdress, Boolean isPremuim){
        super(name, userName, emailAdress, isPremuim);
        
        myContent = new ArrayList<>();
    }

    public void addContent(Content content){
        myContent.add(content);
    }



}
