package org.workfully.http;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.workfully.controllers.OperationTrackerController;

@Path("stats/increment")
public class UpdateStats {

    private Logger log = LogManager.getLogger(UpdateStats.class.getName());
    private OperationTrackerController otc = new OperationTrackerController();

    @PUT
    @Path("/page")
    public Response incrementpageRequests() {
        try {
            otc.incrementPageRequests();
            return Response.accepted(Response.Status.ACCEPTED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/products")
    public Response incrementAllProductsRequests() {
        try {
            otc.incrementAllProductsRequests();
            return Response.accepted(Response.Status.ACCEPTED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/productDetail")
    public Response incrementProductDetailRequests() {
        try {
            otc.incrementProductDetailsRequests();
            return Response.accepted(Response.Status.ACCEPTED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/search")
    public Response incrementSearchRequests() {
        try {
            otc.incrementSearchRequests();
            return Response.accepted(Response.Status.ACCEPTED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/category")
    public Response incrementSearchByCategoryRequests() {
        try {
            otc.incrementSearchByCategoryRequests();
            return Response.accepted(Response.Status.ACCEPTED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/categories")
    public Response incrementCategoriesRequests() {
        try {
            otc.incrementCategoriesRequests();
            return Response.accepted(Response.Status.ACCEPTED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
