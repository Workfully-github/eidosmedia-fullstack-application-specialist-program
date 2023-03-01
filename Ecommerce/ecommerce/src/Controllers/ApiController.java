package Controllers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApiController {
    public JSONArray call(String url, int skip, int limit) {
        try {
            URL GET_URL = new URL(url + "?skip=" + skip + "&limit=" + limit);
    
            HttpURLConnection httpURLConnection = (HttpURLConnection) GET_URL.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = httpURLConnection.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in .readLine()) != null) {
                    response.append(inputLine);
                } in .close();
    
                JSONObject productsObj = new JSONObject(response.toString());
                return productsObj.getJSONArray("products");
    
              
            } else {
                System.out.println("GET request not worked");
                return null;
            }
            // int headerSize = httpURLConnection.getHeaderFields().size();
            // for(int i = 0; i < headerSize; i++) {
            //     System.out.println(httpURLConnection.getHeaderFieldKey(i) + " = " + httpURLConnection.getHeaderField(i));
            // }
        } catch (IOException e) {
            System.out.print(e.getMessage());
            return null;

        }
    }
}
