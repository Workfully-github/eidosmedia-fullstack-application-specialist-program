package org.workfully.view.section;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.workfully.models.content.AbstractContent;
import org.workfully.models.users.AbstractUser;

public class HomeFeed extends AbstractSection {

    /* PROPERTIES */
    private HashMap<AbstractUser, ArrayList<AbstractContent>> globalMap;

    public void showHomeFeed(){
        for (Map.Entry<AbstractUser, ArrayList<AbstractContent>> user : globalMap.entrySet()) {
            
                
        }
    }
    
    
}
