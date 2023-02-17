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
    public void read(Content post){
        //TODO
        //Reading the content maybe can be described by outputing the post to the console
    }
    public void like(Content post){
        //LIKE
    }

    public void comment(Content post){
        //COMMENT
    }

    public void save(Content post){
        //SAVE
        //add a peice of content to the savedContent List
    }
} 