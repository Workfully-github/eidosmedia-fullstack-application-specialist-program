package view;

import controllers.ProductController;
import models.Product;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class ProductView {

    ProductController productController = new ProductController();
    public void showProductById(String url) throws IOException {
        String method = "GET";

        Product product = productController.getProductById(url);
        System.out.println(product.toString());
    }


}
