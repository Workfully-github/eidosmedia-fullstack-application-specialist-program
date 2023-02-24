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

import HttpExercise.Utilities.FullResponseBuilder;
import HttpExercise.Utilities.ParameterStringBuilder;
import HttpExercise.Views.UserActionView;
import HttpExercise.Views.UserInputView;

public class Main {

    public static HashMap<String, String> requestParams = new HashMap<>();
    
    public static void main(String[] args) throws IOException {

        
        // Create connection
        
        UserInputView userInputView = new UserInputView();
        UserActionView userActionView = new UserActionView();

        // user view to ask for input for the URL
        try {
            URL url = new URL(userInputView.askUserInput());
            String method = userActionView.askUserAction();
    
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            
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
    public static void requestParameters(HttpURLConnection con) throws IOException {

        // create view to request params!

        requestParams.put("param1", "val");

        // this propertie needs to be true to add parameters to a request
        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(requestParams));
        out.flush();
        out.close();
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

        System.out.println("\n");
        System.out.println("Status Code: " + status);
        System.out.println("\n");
        System.out.println("Content of the page: ");
        System.out.println(content);
        System.out.println("\n");
    }

    public static void respondFailedRequest(HttpURLConnection con) throws IOException {
        
        int status = con.getResponseCode();

        Reader streamReader = null;

        if(status > 299) streamReader = new InputStreamReader(con.getErrorStream());
        else streamReader = new InputStreamReader(con.getInputStream());

        // read streamReader like in readResponse?
    }
    
}
