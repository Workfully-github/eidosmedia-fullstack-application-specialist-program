package org.workfully.models.content;

import org.workfully.models.users.Author;

public class Tweet extends AbstractContent{

    public Tweet(Author contentAuthor, String textBody) {
        super(contentAuthor, textBody);
    }
    
}
