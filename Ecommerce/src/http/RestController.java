package http;

import netscape.javascript.JSObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.time.Duration;

public class RestController {

   private static final String BASE_URL = "https://dummyjson.com";
   public static final int LIMIT = 30;

  // "https://dummyjson.com/product/search?q=hissji & skip=30 & limit=30"


   public String get(String endpoint,int page,String query){

      String uri = getUrl(endpoint,getPage(page),query);

      System.out.println(uri);

/*      try{
         HttpClient client = HttpClient.newHttpClient();
         HttpRequest request = HttpRequest.newBuilder()
                 .uri(URI.create(uri))
                 .GET()
                 .build();
         HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
         return response.body();


      }catch (IOException | InterruptedException e){
         e.printStackTrace();
         return null;
      }*/

      return "{}";

   }

   public String get(String endpoint,int page){
      return get(endpoint,page,"");
   }

   private String getUrl(String endpoint,String page,String query){
      return  BASE_URL + endpoint + query + page;

   }

   private String getPage(int page){
      page--;
      return "?skip=" +page*LIMIT + "&limit=" + LIMIT;

   }









}
