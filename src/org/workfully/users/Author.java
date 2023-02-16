package org.workfully.users;

import org.workfully.content.AbstractContent;
import org.workfully.users.userInterfaces.CreateContent;

public class Author extends AbstractUser implements CreateContent{

    @Override
    public void read(AbstractContent content) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void comment(String comment, AbstractContent content) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void like(AbstractContent content) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public AbstractContent createContent() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
