package models.users;

import models.contents.Content;

import java.util.ArrayList;

public class AuthorUser extends User{

    private String firstName,lastName;
    private ArrayList<Content> contents = new ArrayList<Content>();

    public AuthorUser(String username,String firstName ,String lastName) {
        super(username);
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getDisplayName(){
        return firstName + " " + lastName;
    }


    public ArrayList<Content> getContents() {
        return contents;
    }

    public void setContents(ArrayList<Content> contents) {
        this.contents = contents;
    }

    public void addContent(Content content){
        contents.add(content);
    }

    public Content getContent(int index){
        return contents.get(index);
    }

    public void updateContent(Content content, int index){
        contents.add(index,content);
    }


}
