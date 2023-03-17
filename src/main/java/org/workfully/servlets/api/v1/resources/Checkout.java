package org.workfully.servlets.api.v1.resources;

import java.net.URI;
import org.apache.hadoop.shaded.javax.ws.rs.core.Response;
import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("checkout")
public class Checkout {

    @POST
    @Path("/session")
    public Response createCheckoutSession(@QueryParam("priceId") String PRICE_ID) {
        try {
            Stripe.apiKey = "sk_test_51Mm3sNBeMaRafwsrpEKYbc3bNKAFYcHfpuFRMmR3WPwgH8K16JTbiytonhGv1s84exqYrLvChvQBENKfE0JO7dik00tl8Rp9WM";

            String YOUR_DOMAIN = "http://localhost:4242";
            SessionCreateParams params = SessionCreateParams.builder()
                    .setMode(SessionCreateParams.Mode.PAYMENT)
                    .setSuccessUrl(YOUR_DOMAIN + "?success=true")
                    .setCancelUrl(YOUR_DOMAIN + "?canceled=true")
                    .addLineItem(
                            SessionCreateParams.LineItem.builder()
                                    .setQuantity(1L)
                                    // Provide the exact Price ID (for example, pr_1234) of the product you want to
                                    // sell
                                    .setPrice(PRICE_ID)
                                    .build())
                    .build();
            Session session = Session.create(params);

            return Response.temporaryRedirect(new URI(session.getUrl()))
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "POST")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}