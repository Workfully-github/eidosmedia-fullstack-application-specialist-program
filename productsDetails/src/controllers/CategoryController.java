package controllers;

import http.HttpController;
import models.Category;
import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoryController {
    public List<String> getListOfCategories() throws IOException {
        String method = "GET";

        String url = ProductController.url_basic + Category.ENDPOINT;
        //read data
        String httpBodyJson = HttpController.getJsonData(url, method);
        JSONArray jsonArray = new JSONArray(httpBodyJson);
        List<String> categories = new ArrayList<>();
        for(int i=0; i<jsonArray.length(); i++) {
            categories.add(jsonArray.getString(i));
        }
        return categories;
    }
}
