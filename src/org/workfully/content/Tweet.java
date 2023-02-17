package org.workfully.content;

import org.workfully.users.Author;

public class Tweet extends AbstractContent{

    public Tweet(Author contentAuthor, String textBody) {
        super(contentAuthor, textBody);
    }
    
}
