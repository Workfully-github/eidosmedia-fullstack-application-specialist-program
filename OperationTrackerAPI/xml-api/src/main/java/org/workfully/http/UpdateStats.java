package org.workfully.http;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.workfully.controllers.OperationTrackerDBController;
import org.workfully.model.OperationTracker;

@Path("stats") // https:localhost:8081/xml-api/increment/
public class UpdateStats {

    private OperationTrackerDBController operationTrackerDBController = new OperationTrackerDBController();
    private Logger log = LogManager.getLogger(UpdateStats.class.getName());
    private final String INCREMENTATION_FAILED = "Incrementation Failed";

    @PUT
    @Path("/page")
    public ResponseBuilder incrementGetProducts() {
        // 🐞 This is a Blocking Operation, we need an async function to deal with it
        try {
            operationTrackerDBController.updateGetProductsStat();

        } catch (Exception e) {
            e.printStackTrace();
            log.warn(INCREMENTATION_FAILED);
            return Response.status(500);
        }
        return Response.status(200);
    }

    @PUT
    @Path("/products")
    public ResponseBuilder incrementGetAllProducts() {
        try {
            operationTrackerDBController.updateGetAllProductsStat();
            return Response.status(200);
        } catch (Exception e) {
            e.printStackTrace();
            log.warn(INCREMENTATION_FAILED);
            return Response.status(500);
        }
    }

    @PUT
    @Path("/product")
    public ResponseBuilder incrementGetProduct() {
        try {
            operationTrackerDBController.updateGetProductStat();
            return Response.status(200);

        } catch (Exception e) {
            e.printStackTrace();
            log.warn(INCREMENTATION_FAILED);
            return Response.status(500);
        }
    }

    @PUT
    @Path("/search")
    public ResponseBuilder incrementSearchCounter() {
        try {
            operationTrackerDBController.updateSearchCounterStat();
            return Response.status(200);
        } catch (Exception e) {
            e.printStackTrace();
            log.warn(INCREMENTATION_FAILED);
            return Response.status(500);
        }
    }

    @PUT
    @Path("/category")
    public ResponseBuilder incrementSearchByCategoryCounter() {
        try {
            operationTrackerDBController.updateSearchByCategoryStat();
            return Response.status(200);
        } catch (Exception e) {
            e.printStackTrace();
            log.warn(INCREMENTATION_FAILED);
            return Response.status(500);
        }
    }

    @PUT
    @Path("/categories")
    public ResponseBuilder incrementGetCategories() {
        try {
            operationTrackerDBController.updateGetCategoriesStat();
            return Response.status(200);
        } catch (Exception e) {
            e.printStackTrace();
            log.warn(INCREMENTATION_FAILED);
            return Response.status(500);
        }
    }

}
