package org.workfully.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MakeFileUtils {

    //private final static String RESOURCES_BASE_PATH = "./src/main/java/org/workfully/resources/";
    private final static String HEROKU_RESOURCES_BASE_PATH = System.getenv("RESOURCES_BASE_PATH");

    private static File makeJsonFile(String data, String jsonName) throws IOException {

        File file = new File(HEROKU_RESOURCES_BASE_PATH + jsonName + ".json");

        if (!file.exists()) {
            System.out.println(jsonName + " created");
            FileWriter writer = new FileWriter(file);
            writer.write(formatJson(data));
            writer.close();
            return file;
        }

        return file;
    }

    private static File makeTempFile(String data, String fileName) {
        String tempDir = HEROKU_RESOURCES_BASE_PATH;
        if (tempDir == null) {
            System.err.println(tempDir + " environment variable not set");
            return null;
        }

        File dir = new File(tempDir);
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                System.err.println("Failed to create temp directory: " + dir.getAbsolutePath());
                return null;
            }
        }

        File file = new File(dir, fileName + ".json");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(formatJson(data));
            System.out.println(file.getAbsolutePath() + " created");
            return file;
        } catch (IOException e) {
            System.err.println("Failed to write to temp file: " + file.getAbsolutePath());
            e.printStackTrace();
            return null;
        }
    }

    private static void mergeFiles(File file, File tempFile) throws IOException {
        file = tempFile;
        tempFile.delete();
    }

    public static String readFile(String filePath) throws IOException {
        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        Object jsonObject = gson.fromJson(reader, Object.class);
        reader.close();
        return gson.toJson(jsonObject);
    }

    public static String readFile(File file) {

        Gson gson = new Gson();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            Object jsonObject = gson.fromJson(reader, Object.class);
            return gson.toJson(jsonObject);
        } catch (Exception e) {
            System.out.println("Unable to read " + file.getName());
            e.printStackTrace();
            return null;
        }
    }

    private static String formatJson(String jsonString) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(gson.fromJson(jsonString, Object.class));
    }

    public static File makeFile(String response, String pathResource) {
        try {
            File tempFile = MakeFileUtils.makeTempFile(response, pathResource);
            File file = MakeFileUtils.makeJsonFile(response, pathResource);

            if (file.hashCode() != tempFile.hashCode()) MakeFileUtils.mergeFiles(file, tempFile);

            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
