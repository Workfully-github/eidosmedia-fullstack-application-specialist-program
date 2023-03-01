package view;

import controllers.ProductController;
import http.HttpController;
import models.Product;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class ProductListView {

    ProductController productController = new ProductController();
    public void showAllProduct(String url) throws IOException {
        List<Product> productList = productController.getAllProduct(url);
        for(int i=0; i<productList.size(); i++) {
            System.out.println(productList.get(i).toString());
        }
    }

    public void showAllProductWithPagination(String url, int skip, int limit) throws IOException {
        this.showAllProduct(url + "?skip=" + skip + "&limit=" + limit);
    }

}
