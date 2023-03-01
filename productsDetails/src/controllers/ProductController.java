package controllers;

import http.HttpController;
import models.Product;
import org.json.JSONObject;
import view.ProductView;

import java.io.IOException;
import java.util.List;

public class ProductController {

    public Product getProductById(String url) throws IOException {
        String method = "GET";

        //read data
        String httpBodyJson = HttpController.getJsonData(url, method);
        Product product = new Product(new JSONObject(httpBodyJson));
        return product;
    }

    public List<Product> getAllProduct(String url) throws IOException {
        String method = "GET";

        //read data
        String httpBodyJson = HttpController.getJsonData(url, method);
        JSONObject jsonObject = new JSONObject(httpBodyJson);
        List<Product> productList = Product.createListProduct(jsonObject.getJSONArray("products"));
        for(int i=0; i<productList.size(); i++) {
            System.out.println(productList.get(i).toString());
        }
        return productList;
    }
    public List<Product>  getWithPagination(String url, int skip, int limit) throws IOException {
        return this.getAllProduct(url + "?skip=" + skip + "&limit=" + limit);
    }
}
