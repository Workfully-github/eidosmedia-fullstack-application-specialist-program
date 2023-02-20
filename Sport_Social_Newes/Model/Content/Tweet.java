package Model.Content;

import Model.Users.Author;

public class Tweet extends Content {
    public Tweet (Author author, String body, Boolean isContentPremium){
        super(author, body, isContentPremium);
    }

    
}
