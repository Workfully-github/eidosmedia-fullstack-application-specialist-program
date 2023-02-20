package org.workfully.models.users.userInterfaces;

import org.workfully.models.content.AbstractContent;
import org.workfully.models.content.UserComment;

public interface CommentContent {
    
    UserComment comment(String comment, AbstractContent content) throws Exception;
}
