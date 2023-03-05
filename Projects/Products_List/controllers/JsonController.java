package Projects.Products_List.controllers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsonController {

    private static final String BASE_URL = "https://dummyjson.com";
    public static final int LIMIT = 30;

    public static String get(String endpoint, int page, String query) {

        String uri = getUrl(endpoint, query, getPage(page));
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String get(String endpoint, int page) {
        return get(endpoint, page, "");
    }

    private static String getUrl(String endpoint, String query, String page) {
        return BASE_URL + endpoint + query + page;
    }

    private static String getPage(int page) {
        if (page == 0) return "";
        else {
            page --;
            return "?skip=" + page * LIMIT + "&limit=" + LIMIT;
        }
    }
}
