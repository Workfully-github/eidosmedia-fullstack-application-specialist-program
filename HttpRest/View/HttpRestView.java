package HttpRest.View;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class HttpRestView {
    

    public static void excecuteRequest(HttpURLConnection connection,String bodyType) {
        
        
        int responseCode;
        
        try {
            // Get Response Code and Headers
            responseCode = connection.getResponseCode();

            String responseMessage = connection.getResponseMessage();
            System.out.println("------------------------------------------------------------------");
            System.out.println("\nResponse Code: " + responseCode + " " + responseMessage);
            System.out.println("------------------------------------------------------------------");
            System.out.println("\nResponse Headers: " + connection.getHeaderFields());
        
            // Get Response Code and Headers
            try {
                // Get Response Body (HTML)
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder responseBody = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    responseBody.append(inputLine);
                }
                in.close();
            
                if(bodyType=="json"){
                    System.out.println("------------------------Response Body j:-----------------------------------");
                    //System.out.println("\nResponse Body: " + responseBody.toString());
                    ReadableJsonResponse.print(responseBody.toString());
                }
                else if(bodyType=="xml") {
                    System.out.println("------------------------Response Body x:-----------------------------------");
                    ReadableXmlResponse.print(responseBody.toString().substring(74));
                }
                else{
                        // Print Response Body
                        System.out.println("------------------------------------------------------------------");
                        System.out.println("\nResponse Body: " + responseBody.toString().substring(74));
                    }
            } catch (IOException e1) {
                System.out.println("------------------------------------------------------------------");
                System.out.println("\nResponse Body: Error");
            } catch (Exception e) {
                System.out.println("\nResponse Body: Xml creation error");
                // this is for the xml step error
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        
    }

}
