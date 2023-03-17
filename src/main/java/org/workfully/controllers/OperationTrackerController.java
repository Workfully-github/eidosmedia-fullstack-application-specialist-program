package org.workfully.controllers;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.workfully.models.OperationTracker;

public class OperationTrackerController {

    private OperationTracker unmarshalledXml(String xml) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(OperationTracker.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        return (OperationTracker) unmarshaller.unmarshal(new StringReader(xml));
    }

    private String marshalledXml(OperationTracker unmarshalledOperationTracker) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(OperationTracker.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter sw = new StringWriter();
        marshaller.marshal(unmarshalledOperationTracker, sw);
        String formattedXml = sw.toString();

        JSONObject jsonObject = XML.toJSONObject(formattedXml);
        return jsonObject.toString();
    }

    public String convertToJson(String xmlRequest) throws JSONException, JAXBException {
        OperationTracker ot = unmarshalledXml(xmlRequest);
        return marshalledXml(ot);
    }
}
