package view;

import controllers.ProductController;
import models.Product;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class ProductView {

    ProductController productController = new ProductController();
    public void showProductById(String id) throws IOException {
        String method = "GET";

        Product product = productController.getProductById(id);
        System.out.println(product.toString());
    }


}
