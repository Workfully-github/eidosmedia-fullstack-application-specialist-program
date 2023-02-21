package Controller.ContentControllers;

import Model.Feed;
import Model.Content.Content;
import Model.Users.User;

public abstract class CreateContentController {
    

    public Content create(Content content){
        return null;
    }

    public void display(Content content, User user, Boolean isFeedDisplay, int index){

    }

    public void feedDisplay(Content content, User user){

    }

    public static void pushContent(Content content){
        content.getAuthor().addContent(content);
        Feed.addContenttoFeed(content);
    }
}
