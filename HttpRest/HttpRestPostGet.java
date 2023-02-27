package HttpRest;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;

import HttpRest.View.HttpRestView;


public class HttpRestPostGet {
    public static void main(String[] args) throws IOException {

        // Get URL and Method from user input
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter URL: ");
        String url = reader.readLine();
        System.out.println("Enter Method (GET or POST): ");
        String method = reader.readLine();
    
        // Open connection and set method
        ConnectionConfig conn = new ConnectionConfig(url, method);
        HttpURLConnection connection = conn.createConnection();
    
        // Request response
        HttpRestView.excecuteRequest(connection,"xml");
    }
    
}
