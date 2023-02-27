package org.workfully;

import org.json.JSONObject;
import org.workfully.controllers.SlideShowController;
import org.workfully.models.Slideshow;
import org.workfully.requests.HttpRequests;

/**
 * Hello world!
 */
public class Sandbox {

    public static void main(String[] args) {

        JSONObject mainJson = new JSONObject((HttpRequests.getBody("https://httpbin.org/json")));

        SlideShowController slideShowController = new SlideShowController(new Slideshow(mainJson.getJSONObject("slideshow")));

        slideShowController.showSlideShowInfo();
   
    }
}
