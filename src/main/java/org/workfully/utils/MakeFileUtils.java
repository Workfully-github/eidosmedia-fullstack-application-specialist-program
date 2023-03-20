package org.workfully.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MakeFileUtils {

    private final static String RESOURCES_BASE_PATH = "src/main/java/org/workfully/resources/";

    private static File makeJsonFile(String data, String jsonName) throws IOException {

        File file = new File(RESOURCES_BASE_PATH + jsonName + ".json");

        if (!file.exists()) {
            System.out.println(jsonName + " created");
            FileWriter writer = new FileWriter(file);
            writer.write(formatJson(data));
            writer.close();
            return file;
        }

        return file;
    }

    private static File makeTempFile(String data, String jsonName) {
        try {
            File file = new File(RESOURCES_BASE_PATH + "temp_" + jsonName + ".json");
            FileWriter writer = new FileWriter(file);
            writer.write(formatJson(data));
            writer.close();
            System.out.println(jsonName + " temp created");
            return file;
        } catch (Exception e) {
            System.out.println("Unable to create tempfile");
            e.printStackTrace();
            return null;
        }

    }

    private static void mergeFiles(File file, File tempFile) throws IOException {
        file = tempFile;
    }

    public static String readFile(String filePath) throws IOException {
        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        Object jsonObject = gson.fromJson(reader, Object.class);
        reader.close();
        return gson.toJson(jsonObject);
    }

    public static String readFile(File file) throws IOException {
        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Object jsonObject = gson.fromJson(reader, Object.class);
        reader.close();
        return gson.toJson(jsonObject);
    }

    private static String formatJson(String jsonString) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(gson.fromJson(jsonString, Object.class));
    }

    public static File makeFile(String response, String path) {
        try {
            File tempFile = MakeFileUtils.makeTempFile(response, path);
            File file = MakeFileUtils.makeJsonFile(response, path);

            if (file.hashCode() != tempFile.hashCode())
                MakeFileUtils.mergeFiles(file, tempFile);

            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } /*
           * finally {
           * new File(RESOURCES_BASE_PATH + "temp_" + path + ".json").delete();
           * System.out.println("Temp file deleted");
           * }
           */
    }

    public static void main(String[] args) {
        makeTempFile("Test", "products_id_1");
    }
}
