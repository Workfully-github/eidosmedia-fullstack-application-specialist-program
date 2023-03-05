package Projects.Products_List.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.ParseException;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonController {

    private static final String BASE_URL = "https://dummyjson.com";
    public static final int LIMIT = 30;

    public static String get(String endpoint, int page, String query) {

        String uri = getUrl(endpoint, query, getPage(page));
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String get(String endpoint, int page) {
        return get(endpoint, page, "");
    }

    private static String getUrl(String endpoint, String query, String page) {
        return BASE_URL + endpoint + query + page;
    }

    private static String getPage(int page) {
        // Pages 1, 2, 3, 4, etc
        // So in page 1 skip is 0 = 1 - 1 * limit
        // page 2 skip is 30 = 2 - 1 * limit
        if (page == 0) return "";
        else {
            page --;
            return "?skip=" + page * LIMIT + "&limit=" + LIMIT;
        }
    }
    


    // DELETE

    /* public JSONArray getJson(int skip, int limit) throws IOException, ParseException {

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

    } */


}
