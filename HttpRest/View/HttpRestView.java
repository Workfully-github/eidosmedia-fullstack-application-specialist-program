package HttpRest.View;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import HttpRest.View.HttpRestView;

public class HttpRestView {
    

    public static void excecuteRequest(HttpURLConnection connection) throws IOException{
        // Get Response Code and Headers
        int responseCode = connection.getResponseCode();
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
        in.close();
    
        // Print Response Body
        System.out.println("------------------------------------------------------------------");
        System.out.println("\nResponse Body: " + responseBody.toString());
    }
}
