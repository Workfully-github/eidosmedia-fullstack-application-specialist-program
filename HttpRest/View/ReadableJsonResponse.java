package HttpRest.View;
import HttpRest.Models.Slide;
import HttpRest.Models.Slideshow;
import org.json.JSONObject;

import java.io.IOException;

public class ReadableJsonResponse {
   public static void print(String json) throws IOException {
    JSONObject jsonObject = new JSONObject(json);
    //String prettyJsonString = jsonObject.toString(4);
    //System.out.println(prettyJsonString);

       Slideshow slideshow = new Slideshow(jsonObject);

       System.out.println("title : " + slideshow.getTitle());
       System.out.println("Author : " + slideshow.getAuthor());
       System.out.println("date :" + slideshow.getDate());
       System.out.println("Slides :" );

       for (Slide slide : slideshow.getSlides()) {
           System.out.println("---title : " + slide.getTitle());
           System.out.println("---type : " + slide.getType());
           System.out.println("---Items : " );
           if (slide.getItems() != null) {
               for (String item : slide.getItems()) {
                   System.out.println(item);
               }
           }
       }

   }
}
