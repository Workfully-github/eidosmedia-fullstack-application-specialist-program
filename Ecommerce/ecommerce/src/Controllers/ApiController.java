package Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApiController {
    private static String url = "";

    public static final String BASE_URL = "https://dummyjson.com/products/";

    public static final String SEARCH_ROUT = "search/";
    public static final String CATEGORIES_ROUT = "categories/";
    public static final String CATEGORY_ROUT = "category/";
    public static final String SEARCH_QUERY_STRING = "?q=";

    public JSONArray call(String url) {
        try {
            URL GET_URL = new URL(url);

            HttpURLConnection httpURLConnection = (HttpURLConnection) GET_URL.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = httpURLConnection.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONObject productsObj = new JSONObject(response.toString());
                return productsObj.getJSONArray("products");

            } else {
                System.out.println("GET request not worked");
                return null;
            }
            // int headerSize = httpURLConnection.getHeaderFields().size();
            // for(int i = 0; i < headerSize; i++) {
            // System.out.println(httpURLConnection.getHeaderFieldKey(i) + " = " +
            // httpURLConnection.getHeaderField(i));
            // }
        } catch (IOException e) {
            System.out.print(e.getMessage());
            return null;

        }
    }

    public JSONArray callCategories() {
        try {
            url = getUrl(CATEGORIES_ROUT);
            URL GET_URL = new URL(url);

            HttpURLConnection httpURLConnection = (HttpURLConnection) GET_URL.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = httpURLConnection.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONArray productsObj = new JSONArray(response.toString());
                return productsObj;

            } else {
                System.out.println("GET request not worked");
                return null;
            }
            // int headerSize = httpURLConnection.getHeaderFields().size();
            // for(int i = 0; i < headerSize; i++) {
            // System.out.println(httpURLConnection.getHeaderFieldKey(i) + " = " +
            // httpURLConnection.getHeaderField(i));
            // }
        } catch (IOException e) {
            System.out.print(e.getMessage());
            return null;

        }
    }

    public JSONObject getProductById(int id) {
        try {

            URL GET_URL = new URL(getUrl(Integer.toString(id)));

            HttpURLConnection httpURLConnection = (HttpURLConnection) GET_URL.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = httpURLConnection.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONObject productsObj = new JSONObject(response.toString());
                return productsObj;

            } else {
                System.out.println("GET request not worked");
                return null;
            }
            // int headerSize = httpURLConnection.getHeaderFields().size();
            // for(int i = 0; i < headerSize; i++) {
            // System.out.println(httpURLConnection.getHeaderFieldKey(i) + " = " +
            // httpURLConnection.getHeaderField(i));
            // }
        } catch (IOException e) {
            System.out.print(e.getMessage());
            return null;

        }
    }

    public JSONArray fetchProducts(int page) {
        String pageQueries = NavigationsController.pagetranslator(page);
        url = getUrl(pageQueries);
        return call(url);
    }

    public JSONArray fetchSearchedProducts(String searchQuery) {
        url = getUrl(SEARCH_ROUT, SEARCH_QUERY_STRING, searchQuery);
        return call(url);
    }

    public JSONArray fetchProductsByCategory(String category) {
        url = getUrl(CATEGORY_ROUT, category);
        return call(url);
    }

    public String getUrl(String... strings) {
        String urlTower = BASE_URL;
        for (String string : strings) {
            urlTower += string;
        }
        return urlTower;
    }
}
