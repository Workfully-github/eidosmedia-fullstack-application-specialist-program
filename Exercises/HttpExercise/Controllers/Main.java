package HttpExercise.Controllers;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/* import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue; */
import org.json.*;

import HttpExercise.Models.SlideShow;
import HttpExercise.Utilities.FullResponseBuilder;
import HttpExercise.Utilities.ParameterStringBuilder;
import HttpExercise.Views.UserActionView;
import HttpExercise.Views.UserInputView;

public class Main {

    public static HashMap<String, String> requestParams = new HashMap<>();
    
    public static void main(String[] args) throws IOException, ParseException {

        // https://httpbin.org/json

        // Create connection
        
        UserInputView userInputView = new UserInputView();
        UserActionView userActionView = new UserActionView();

        // user view to ask for input for the URL
        try {
            URL url = new URL(userInputView.askUserInput());
            String method = userActionView.askUserAction();

            //URL urlPost = new URL("https://httpbin.org/post");
    
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //HttpURLConnection httpURLConnectionPost = (HttpURLConnection) urlPost.openConnection();
            
            // setRequestMethod sets the action to do - GET, POST, DELETE, etc.
            httpURLConnection.setRequestMethod(method);

            // Setting request headers
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            String contentType = httpURLConnection.getHeaderField("Content-Type");

            // If we wish to set connect and read timeouts
            /* httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000); */

            if (method == "POST") requestParameters(httpURLConnection);

            readResponse(httpURLConnection);

            System.out.println(FullResponseBuilder.getFullResponse(httpURLConnection));

            respondFailedRequest(httpURLConnection);

            
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }    
    }

    // Add parameters to a request
    public static void requestParameters(HttpURLConnection con) {

        try {
            // create view to request params!
    
            requestParams.put("param1", "val");
    
            // this propertie needs to be true to add parameters to a request
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(ParameterStringBuilder.getParamsString(requestParams));
            out.flush();
            out.close();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readResponse(HttpURLConnection con) throws IOException, ParseException {

        int status = con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        //in.close();

        // close the connection
        //con.disconnect();

        //readJsonResponse(content);

        readXmlResponse(content);
    }

    public static void readJsonResponse(StringBuffer con) throws JSONException {

        // https://httpbin.org/json
        // https://httpbin.org/xml

        try {
            System.out.println("\n");
            String responseString = con.toString();
            
            JSONObject response = new org.json.JSONObject(responseString);
            JSONObject slideshowJSON = response.getJSONObject("slideshow");
            
            SlideShow slideShow = new SlideShow(slideshowJSON);
            
            System.out.println("\n");
            System.out.println("Author: " + slideShow.getAuthor());
            System.out.println("Date: " + slideShow.getDate());
            System.out.println("Title: " + slideShow.getTitle());
            
            System.out.println("Slides: ");
            for (int i = 0; i < slideShow.getSlide().size(); i++) {
                System.out.println("Title: " + slideShow.getSlide().get(i).getTitle());
                System.out.println("Type: " + slideShow.getSlide().get(i).getType());
                System.out.println("Items: " + slideShow.getSlide().get(i).getItems());
            }
            System.out.println("\n");
            
            
        } catch (Exception e) {
            e.getStackTrace();
        } 
    }

    public static void readXmlResponse(StringBuffer con) throws JSONException {

        // https://httpbin.org/json
        // https://httpbin.org/xml

        try {

            System.out.println("\n");
            String responseString = con.toString();
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
            DocumentBuilder builder = factory.newDocumentBuilder();
           
            Document doc = builder.parse(new InputSource(new StringReader(responseString)));

            SlideShow slideShow = new SlideShow(doc);

            
            /* Element slideshow = doc.getDocumentElement(); */
            //NodeList slide = slideshow.getElementsByTagName("slide");
            //NamedNodeMap slide = slideshow.getAttributes();

            System.out.println("\n");
            System.out.println("Title: " + slideShow.getTitle());
            System.out.println("Date: " + slideShow.getDate());
            System.out.println("Author: " + slideShow.getAuthor());
            
            /* for(int i = 0; i < slide.getLength(); i++) {
                System.out.println("Slides: " + slide.item(i));
            }
            System.out.println("\n"); */
            
            
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void respondFailedRequest(HttpURLConnection con) throws IOException {
        
        int status = con.getResponseCode();

        Reader streamReader = null;

        if(status > 299) streamReader = new InputStreamReader(con.getErrorStream());
        else streamReader = new InputStreamReader(con.getInputStream());

        // read streamReader like in readResponse?
    }

    
}
