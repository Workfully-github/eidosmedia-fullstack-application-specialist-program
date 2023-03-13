package org.workfully.http;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.workfully.models.OperationTracker;

public class Test {
    public static void main(String[] args) {
        try {
        JAXBContext jc = JAXBContext.newInstance(OperationTracker.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("C:/Users/ricardo.mendes/Documents/WorkfullyTraining/ECommerceFullstackApp/OperationTrackerAPI/xml-api/src/main/java/org/workfully/database/OperationTracker.xml");
        OperationTracker ot = (OperationTracker) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(ot, System.out);

    } catch (JAXBException e) {
        e.printStackTrace();
    }


    }
}
