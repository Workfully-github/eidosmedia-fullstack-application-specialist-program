package org.workfully.controllers;

import org.workfully.models.OperationTracker;

public class OperationTrackerController {

    private OperationTracker operationTracker;

    public int getProductsCounter() {
        return operationTracker.getGetProductsCounter();
    }

    public void incrementGetProductsCounter() {
        this.operationTracker.setProductsCounter(getProductsCounter() + 1);
    }

    public int getProductCounter() {
        return operationTracker.getProductCounter();
    }

    public void incrementProductCounter() {
        this.operationTracker.setProductCounter(getProductCounter() + 1);
    }

}