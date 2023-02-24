package http_json_xml_parser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import com.googlecode.json.simple.JSONValue;
import com.googlecode.json.simple.JSONbject;


public class Request {
    private static final String USER_AGENT = "Mozilla/5.0";

    public void get(URL GET_URL) {
        

        // URL obj = new URL(GET_URL);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) GET_URL.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);
            int responseCode = httpURLConnection.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
    
    
                while ((inputLine = in .readLine()) != null) {
                    response.append(inputLine);
                } in .close();
    
                // print result
                // System.out.println(response.toString());
                Object obj = JSONValue.parse(response.toString());
                JSONObject Jobj = (JSONObject) obj;
                String apiTitle = (String) Jobj.get("author");
                System.out.println(apiTitle);
                // String author = (String) Jobj.get("slideshow");
            } else {
                System.out.println("GET request not worked");
            }

            int headerSize = httpURLConnection.getHeaderFields().size();
        
            for(int i = 0; i < headerSize; i++) {
                System.out.println(httpURLConnection.getHeaderFieldKey(i) + " = " + httpURLConnection.getHeaderField(i));
            }
            
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }


       
    }

    public void sendPOST(URL POST_URL) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) POST_URL.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);

        // For POST only - START
        httpURLConnection.setDoOutput(true);
        OutputStream os = httpURLConnection.getOutputStream();
        // os.write("search?q=post".getBytes());
        os.flush();
        os.close();
        // For POST only - END

        int responseCode = httpURLConnection.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();

            //Print headers

            int headerSize = httpURLConnection.getHeaderFields().size();
        
            for(int i = 0; i < headerSize; i++) {
                System.out.println(httpURLConnection.getHeaderFieldKey(i) + " = " + httpURLConnection.getHeaderField(i));
            }

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("POST request not worked");
        }
    }
}
