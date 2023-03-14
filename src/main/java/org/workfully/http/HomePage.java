package org.workfully.http;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class HomePage {

    @GET
    public Response getDocumentationPage() {

        try {
            URI url = new URI("https://documenter.getpostman.com/view/15524879/2s93JushiY");
            return Response.temporaryRedirect(url).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
