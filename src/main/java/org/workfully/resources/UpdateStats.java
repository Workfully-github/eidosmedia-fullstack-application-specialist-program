package org.workfully.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.workfully.controllers.OperationTrackerDBController;

@Path("stats") // https:localhost:8081/xml-api/increment/
public class UpdateStats {

    OperationTrackerDBController operationTrackerDBController = new OperationTrackerDBController();

    @PUT
    @Path("/page")
    public ResponseBuilder incrementGetProducts() {
        // 🐞 This is a Blocking Operation, we need an async function to deal with it
        try {
            operationTrackerDBController.updateGetProductsStat();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500);
        }
        return Response.status(200);
    }

    @PUT
    @Path("/products")
    public ResponseBuilder incrementGetAllProducts() {

        try {
            operationTrackerDBController.updateGetAllProductsStat();

        } catch (Exception e) {

            e.printStackTrace();
            return Response.status(500);
        }
        return Response.status(200);

    }

    @PUT
    @Path("/product")
    public ResponseBuilder incrementGetProduct() {

        try {
            operationTrackerDBController.updateGetProductStat();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500);
        }
        return Response.status(200);

    }

    @PUT
    @Path("/search")
    public ResponseBuilder incrementSearchCounter() {

        try {
            operationTrackerDBController.updateSearchCounterStat();
            ;

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500);
        }
        return Response.status(200);

    }

    @PUT
    @Path("/category")
    public ResponseBuilder incrementSearchByCategoryCounter() {

        try {
            operationTrackerDBController.updateSearchByCategoryStat();
            ;

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500);
        }
        return Response.status(200);

    }

    @PUT
    @Path("/categories")
    public ResponseBuilder incrementGetCategories() {

        try {
            operationTrackerDBController.updateGetCategoriesStat();
            ;

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500);
        }
        return Response.status(200);

    }
}
