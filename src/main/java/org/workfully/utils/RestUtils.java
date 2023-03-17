package org.workfully.utils;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import javax.ws.rs.core.Response;

public class RestUtils {

    public Response getBody(String url) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpResponse httpResponse = httpClient.execute(new HttpGet(url));
            HttpEntity httpEntity = httpResponse.getEntity();

            if (HttpStatus.SC_OK == httpResponse.getStatusLine().getStatusCode()) {
                return Response.ok(EntityUtils.toString(httpEntity))
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Methods", "GET")
                        .encoding("gzip")
                        .build();
            }

            EntityUtils.consume(httpEntity);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Request failed with status: " + httpResponse.getStatusLine().getStatusCode())
                    .build();

        } catch (IOException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error making request: " + e.getMessage())
                    .build();
        }
    }

    public void updateStats(String route) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut request = new HttpPut("https://optracker.herokuapp.com/api/stats/increment/" + route);
        try {
            httpClient.execute(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
