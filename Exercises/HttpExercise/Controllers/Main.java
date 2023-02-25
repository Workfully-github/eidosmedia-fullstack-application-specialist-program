package HttpExercise.Controllers;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

import HttpExercise.Utilities.FullResponseBuilder;
import HttpExercise.Utilities.ParameterStringBuilder;
import HttpExercise.Views.UserActionView;
import HttpExercise.Views.UserInputView;

public class Main {

    public static HashMap<String, String> requestParams = new HashMap<>();
    
    public static void main(String[] args) throws IOException {

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

    public static void readResponse(HttpURLConnection con) throws IOException {

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

        /* System.out.println("\n");
        System.out.println("Status Code: " + status);
        System.out.println("\n");
        System.out.println("Content of the page: ");
        System.out.println(content);
        System.out.println("\n"); */

        readJsonResponse(content);
    }

    public static void readJsonResponse(StringBuffer con) {

        String content = con.toString();
        String[] newContent = content.split(" ");
        //\"slideshow\":
        System.out.println(newContent.length);

        Map<String, String> myMap = new HashMap<String, String>();
        
        for (int i = 0; i < newContent.length; i++) {
            System.out.println(newContent[i]);
        }
        System.out.println("\n");
        
        String s = newContent[1];
        
        String[] pairs = s.split(",");

        for (int i = 0; i < pairs.length; i++) {
            System.out.println(pairs[i]);
        }

        for (int i=0;i<pairs.length;i++) {
            String pair = pairs[i];
            String[] keyValue = pair.split(":");
            myMap.put(keyValue[0], (keyValue[1]));
        }
        System.out.println(myMap);

        for (Map.Entry<String, String> set :
             myMap.entrySet()) {
 
            // Printing all elements of a Map
            System.out.println(set.getKey() + " = "
                               + set.getValue());
        }
        
        /* System.out.println("\n");
        for (int i = 0; i < newContent.length; i++) {
            System.out.println(newContent[i]);
        }
        System.out.println("\n"); */
    }

    public static void respondFailedRequest(HttpURLConnection con) throws IOException {
        
        int status = con.getResponseCode();

        Reader streamReader = null;

        if(status > 299) streamReader = new InputStreamReader(con.getErrorStream());
        else streamReader = new InputStreamReader(con.getInputStream());

        // read streamReader like in readResponse?
    }

    
}
