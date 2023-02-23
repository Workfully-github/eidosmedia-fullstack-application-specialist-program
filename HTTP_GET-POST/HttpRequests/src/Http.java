
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Http {

   public static void start() throws Exception{

       System.out.println("Past your URL below:");
       Scanner in = new Scanner(System.in);
       
       String  urll = in.nextLine();
       URL URL = new URL(urll);
       
       System.out.println("What kind of requests are you doing?\n [0] --> GET\n [1] --> POST\n");
       int reqType = in.nextInt();
       Request request = new Request();
       if(reqType == 0) {
           request.get(URL);
        }else{
            request.sendPOST(URL);
        }
    }
}
