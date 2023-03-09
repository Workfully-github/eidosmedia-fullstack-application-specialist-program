package com.workfully.xmlresources;

import org.json.JSONObject;
import org.json.XML;

import com.workfully.http.RestController;

public class XmlHandler {

    RestController rest = new RestController();

    public void getXML() {

        JSONObject json = new JSONObject(rest.getBody("http://localhost:8081/xml-api/stats"));
        String xml = XML.toString(json);

        System.out.println(xml);
    }

    public static void main(String[] args) {
        XmlHandler xmlHandler = new XmlHandler();
        xmlHandler.getXML();
    }
}
