package http;

import javax.json.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpController {
    public static String getResponse(String url) throws IOException {

        String method = "GET";
        HttpURLConnection connection =  (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod(method.toUpperCase());
        connection.setDoOutput(true);

        int responseCode;
        try {
            // Get Response Body (HTML)
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder responseBody = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                responseBody.append(inputLine);
            }
            //System.out.println("\nResponse Body: " + responseBody.toString());
            return responseBody.toString();
        }
        catch (Exception e){
            System.out.println("Http request error");
            return "{}";
        }

    }
}
