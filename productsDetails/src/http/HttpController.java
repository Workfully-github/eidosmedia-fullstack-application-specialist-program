package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpController {
    public static String getJsonData(String url, String method) throws IOException {

        HttpURLConnection connection =  (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod(method.toUpperCase());
        connection.setDoOutput(true);

        int responseCode;
        try {
            // Get Response Code and Headers
            responseCode = connection.getResponseCode();

            String responseMessage = connection.getResponseMessage();
            System.out.println("------------------------------------------------------------------");
            System.out.println("\nResponse Code: " + responseCode + " " + responseMessage);
            System.out.println("------------------------------------------------------------------");
            System.out.println("\nResponse Headers: " + connection.getHeaderFields());

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
