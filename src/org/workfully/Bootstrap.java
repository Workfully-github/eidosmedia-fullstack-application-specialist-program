package org.workfully;

import org.workfully.controllers.users.GlobalContentMapController;
import org.workfully.models.content.GlobalContentMap;


public class Bootstrap {

    /* PROPERTIES */
    private static GlobalContentMapController globalContentMapController;


    public Bootstrap() {
        this.globalContentMapController = bootstrapGlobalContentMapController();        
    }

    /* GETTERS */
    public static GlobalContentMapController getGlobalContentMapController() {
        return globalContentMapController;
    }

    /* METHODS */

    private GlobalContentMapController bootstrapGlobalContentMapController() {
        return new GlobalContentMapController(new GlobalContentMap());
    }

    /* GETTERS */


}
