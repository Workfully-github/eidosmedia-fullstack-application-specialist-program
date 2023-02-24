package org.workfully;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpRequests {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static void getHeaders(String url) {

        HttpHead httpHead = new HttpHead(url);

        try {

            CloseableHttpResponse response = httpClient.execute(httpHead);

            List<Header> httpHeaders = Arrays.asList(response.getAllHeaders());
            for (Header header : httpHeaders) {
                System.out.println("Headers.. name,value:" + header.getName() + "," + header.getValue());
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static int getStatusCode(String url) {

        HttpGet request = new HttpGet(url);

        try {

            CloseableHttpResponse response = httpClient.execute(request);

            System.out.println(url + " " + response.getStatusLine());

            return response.getStatusLine().getStatusCode();

        } catch (Exception e) {

            System.out.println(e.getMessage());
            return 0;
        }
    }

    public static void getBody(String url) {

        HttpGet request = new HttpGet(url);

        try {

            CloseableHttpResponse response = httpClient.execute(request);

            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode >= 200 && statusCode < 300) {

                HttpEntity entity = response.getEntity();

                String contentBody = EntityUtils.toString(entity);

                System.out.println(contentBody);

                return;
            }

            System.out.println(response.getStatusLine());

        } catch (IOException e) {

            System.err.println("HTTP request failed: " + e.getMessage());
        }
    }
}
