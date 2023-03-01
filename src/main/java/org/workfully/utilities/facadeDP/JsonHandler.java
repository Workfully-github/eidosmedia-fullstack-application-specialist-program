package org.workfully.utilities.facadeDP;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.workfully.Sandboxes.JsonSandbox;
import org.workfully.utilities.factories.StringFactory;

public class JsonHandler {

    public static void writeToJsonFile(JSONObject jsonObject) {
        JsonSandbox.JSON_ARRAY.add(jsonObject);

        try {
            FileWriter file = new FileWriter(StringFactory.JSON_PATH);
            file.write(JsonSandbox.JSON_ARRAY.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
