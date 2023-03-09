package org.workfully.xmlresources;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import org.workfully.http.RestController;
import org.xml.sax.InputSource;

public class XmlHandler {

    RestController rest = new RestController();

    public Document getXML() {

        try {
            String statsDataString = rest.getBody("http://localhost:8081/xml-api/stats");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(statsDataString)));
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }


    
}
