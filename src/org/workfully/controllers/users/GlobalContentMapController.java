package org.workfully.controllers.users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.workfully.models.content.AbstractContent;
import org.workfully.models.content.GlobalContentMap;
import org.workfully.models.users.AbstractUser;

public class GlobalContentMapController {

    private GlobalContentMap globalContentMapModel;
    private HashMap<AbstractUser, ArrayList<AbstractContent>> globalMap;

    /* CONSTRUCTOR */
    public GlobalContentMapController(GlobalContentMap globalContentMapModel) {
        this.globalContentMapModel = globalContentMapModel;
        this.globalMap = globalContentMapModel.getGlobalContentLogMap();
    }

    /* GETTERS */
    public GlobalContentMap getGlobalContentMap() {
        return globalContentMapModel;
    }

    public HashMap<AbstractUser, ArrayList<AbstractContent>> getGlobalMap() {
        return globalMap;
    }

    /* METHODS */
    public void addAuthorContentToGlobalContentMap(AbstractUser author, AbstractContent content) {
        if(globalMap.get(author) == null)
            globalMap.put(author, new ArrayList<>());
            
        globalMap.get(author).add(content);
    }

}
