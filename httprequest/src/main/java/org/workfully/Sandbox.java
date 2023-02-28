package org.workfully;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.StringReader;
import java.io.IOException;

import org.json.JSONObject;
import org.workfully.controllers.SlideShowController;
import org.workfully.models.Slideshow;
import org.workfully.requests.HttpRequests;

/**
 * Hello world!
 */
public class Sandbox {

    public static void main(String[] args) {

        try {
            JSONObject json = new JSONObject((HttpRequests.getBody("https://httpbin.org/json"))).getJSONObject("slideshow");

            //HttpRequests.getHeaders("https://httpbin.org/json");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xml = builder.parse(new InputSource(new StringReader(HttpRequests.getBody("https://httpbin.org/xml"))));

            SlideShowController slideShowController = new SlideShowController(new Slideshow(json, HttpRequests.getContentType("https://httpbin.org/json"))); //json.getJSONObject("slideshow")

            slideShowController.showSlideShowInfo();

        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}