package Projects.Products_List.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonController {
    
    public JSONArray getJson(int skip, int limit) throws IOException, ParseException {

        URL url = new URL("https://dummyjson.com/products?skip="+skip+"&limit="+limit);
        
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        
        httpURLConnection.setRequestMethod("GET");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        } in .close();
        
        String responseString = content.toString();
        
        JSONObject response = new JSONObject(responseString);
        JSONArray productJSONArray = response.getJSONArray("products");
        
        return productJSONArray;  

    }

    public JSONArray getQueryJson(int skip, int limit, String query) throws IOException, ParseException {

        URL url = new URL("https://dummyjson.com/products/search?q="+query+"&limit="+limit+"&skip="+skip);
        
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        
        httpURLConnection.setRequestMethod("GET");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        } in .close();
        
        String responseString = content.toString();
        
        JSONObject response = new JSONObject(responseString);
        JSONArray productJSONArray = response.getJSONArray("products");
        
        return productJSONArray;  

    }


}
