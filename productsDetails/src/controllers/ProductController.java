package controllers;

import http.HttpController;
import models.Product;
import org.json.JSONArray;
import org.json.JSONObject;
import view.ProductView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductController {

    public static final String url_basic = "https://dummyjson.com/products";

    public Product getProductById(String id) throws IOException {
        String method = "GET";
        String url = ProductController.url_basic + "/" + id;
        //read data
        String httpBodyJson = HttpController.getJsonData( url, method);
        Product product = new Product(new JSONObject(httpBodyJson));
        return product;
    }

    public List<Product> getAllProduct(String urlToAdd) throws IOException {
        String method = "GET";

        String url = ProductController.url_basic + urlToAdd;
        //read data
        String httpBodyJson = HttpController.getJsonData(url, method);
        JSONObject jsonObject = new JSONObject(httpBodyJson);
        List<Product> productList = Product.createListProduct(jsonObject.getJSONArray("products"));
        return productList;
    }

    public List<Product> getAllProduct() throws IOException {
        String method = "GET";

        //read data
        String httpBodyJson = HttpController.getJsonData(ProductController.url_basic, method);
        JSONObject jsonObject = new JSONObject(httpBodyJson);
        List<Product> productList = Product.createListProduct(jsonObject.getJSONArray("products"));

        return productList;
    }


    public List<Product> getSearch(String search) throws IOException {
        String method = "GET";

        String urlSearch = ProductController.url_basic + "/search?q=" + search;
        //read data
        String httpBodyJson = HttpController.getJsonData(urlSearch, method);
        JSONObject jsonObject = new JSONObject(httpBodyJson);
        List<Product> productList = Product.createListProduct(jsonObject.getJSONArray("products"));

        return productList;
    }


}
