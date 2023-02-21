package org.workfully.models.content;

import java.util.ArrayList;
import java.util.HashMap;

import org.workfully.models.users.AbstractUser;

public class GlobalContentMap {

    private HashMap<AbstractUser, ArrayList<AbstractContent>> globalContentLogMap;

   
    public GlobalContentMap() {
        this.globalContentLogMap = new HashMap<>(){};
    }

    public HashMap<AbstractUser, ArrayList<AbstractContent>> getGlobalContentLogMap() {
        return globalContentLogMap;
    }
}
 