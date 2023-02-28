package http_json_xml_parser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
// import com.googlecode.json.simple.JSONValue;
// import com.googlecode.json.simple.JSONbject;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

// import org.json.simple.JSONArray;
// import org.json.simple.JSONObject;
// import org.json.simple.JSONValue;
import org.json.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;



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
    
                

                // JSONObject responseObj = new JSONObject(response.toString());
                // JSONObject slideshowObj = responseObj.getJSONObject("slideshow");
                try {
                    
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document doc = builder.parse(new InputSource(new StringReader(response.toString())));
    
                    Slideshow mySlideshow = new Slideshow(doc);
                    // System.out.println("-------------------------\n" + mySlideshow.getAuthor());
    
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }


                //Getting the slides content
                


                
                // System.out.println("A slideshow by: " + slideshowObj.get("author") + " | " + "on: " + slideshowObj.get("date") );
                // System.out.println(slide1.get("title"));
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
