package org.workfully.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/* USING APACHE BECAUSE PROJECT IS JAVA 8 */
public class RestController {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public void getHeaders(String url) {

        HttpHead httpHead = new HttpHead(url);

        try {

            CloseableHttpResponse response = httpClient.execute(httpHead);

            List<Header> httpHeaders = Arrays.asList(response.getAllHeaders());

            for (Header header : httpHeaders) {
                System.out.println(header.getName() + " : " + header.getValue());
            }

        } catch (IOException e) {

            System.err.println("HTTP request failed: " + e.getMessage());

        }
    }

    public String getContentType(String url) {

        HttpHead httpHead = new HttpHead(url);

        try {

            CloseableHttpResponse response = httpClient.execute(httpHead);

            return response.getHeaders("content-type")[0].getValue();

        } catch (IOException e) {

            System.err.println("HTTP request failed: " + e.getMessage());
            return "";
        }
    }

    public int getStatusCode(String url) {

        HttpGet request = new HttpGet(url);

        try {

            CloseableHttpResponse response = httpClient.execute(request);

            return response.getStatusLine().getStatusCode();

        } catch (Exception e) {

            System.out.println(e.getMessage());
            return -1;
        }
    }

    public String getStatusLine(String url) {

        HttpGet request = new HttpGet(url);

        try {

            CloseableHttpResponse response = httpClient.execute(request);

            return response.getStatusLine().toString();

        } catch (Exception e) {

            return e.getMessage();
        }
    }

    public String getBody(String url) {

        HttpGet request = new HttpGet(url);

        try {

            CloseableHttpResponse response = httpClient.execute(request);

            int statusCode = response.getStatusLine().getStatusCode();

            String contentBody = "";

            if (statusCode >= 200 && statusCode < 300) {

                HttpEntity entity = response.getEntity();

                contentBody = EntityUtils.toString(entity);

                // System.out.println(contentBody);

            }

            return contentBody;

        } catch (IOException e) {

            System.err.println("HTTP request failed: " + e.getMessage());
            return "";
        }
    }

    // EXAMPLE POST REQUEST
    public void postRequest(String url, String param1, String param2) {

        HttpPost httpPost = new HttpPost(url);

        final List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("param", param1));
        params.add(new BasicNameValuePair("param", param2));

        try {

            httpPost.setEntity(new UrlEncodedFormEntity(params));

            CloseableHttpClient client = HttpClients.createDefault();

            CloseableHttpResponse response = (CloseableHttpResponse) client
                    .execute(httpPost);

            final StatusLine statusCode = response.getStatusLine();

            System.out.println(statusCode);

            getHeaders(url);
            getBody(url);

        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (ClientProtocolException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
