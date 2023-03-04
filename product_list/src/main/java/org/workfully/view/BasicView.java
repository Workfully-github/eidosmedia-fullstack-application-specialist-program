package org.workfully.view;

import org.workfully.controllers.APIController;
import org.workfully.view.interfaces.Displays;

public abstract class BasicView implements Displays {

    protected APIController apiController;

    public BasicView() {
        this.apiController = new APIController();
    }

    

}
