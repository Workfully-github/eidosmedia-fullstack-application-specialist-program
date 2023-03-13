package org.workfully.controllers;
import org.workfully.http.APIController;
import org.workfully.models.Stats;
public class StatsController {
    private APIController apiController;
    public CategoryController() {
        this.apiController = new APIController();
    }
    
    public Stats getStat() {
        return apiController.getStats();
    }
}
