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
            log.info("incrementpageRequests successeful");
            return Response.accepted(Response.Status.ACCEPTED).build();
        } catch (Exception e) {
            log.error("incrementpageRequests error ", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/products")
    public Response incrementAllProductsRequests() {
        try {
            otc.incrementAllProductsRequests();
            log.info("incrementAllProductsRequests successeful");
            return Response.accepted(Response.Status.ACCEPTED).build();
        } catch (Exception e) {
            log.error("incrementAllProductsRequests error ", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/productDetail")
    public Response incrementProductDetailRequests() {
        try {
            otc.incrementProductDetailsRequests();
            log.info("incrementProductDetailRequests successeful");
            return Response.accepted(Response.Status.ACCEPTED).build();
        } catch (Exception e) {
            log.error("incrementProductDetailRequests error ", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/search")
    public Response incrementSearchRequests() {
        try {
            otc.incrementSearchRequests();
            log.info("incrementSearchRequests successeful");
            return Response.accepted(Response.Status.ACCEPTED).build();
        } catch (Exception e) {
            log.error("incrementSearchRequests error ", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/category")
    public Response incrementSearchByCategoryRequests() {
        try {
            otc.incrementSearchByCategoryRequests();
            log.info("incrementSearchByCategoryRequests successeful");
            return Response.accepted(Response.Status.ACCEPTED).build();
        } catch (Exception e) {
            log.error("incrementSearchByCategoryRequests error ", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/categories")
    public Response incrementCategoriesRequests() {
        try {
            otc.incrementCategoriesRequests();
            log.info("incrementCategoriesRequests successeful");
            return Response.accepted(Response.Status.ACCEPTED).build();
        } catch (Exception e) {
            log.error("incrementCategoriesRequests error ", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
