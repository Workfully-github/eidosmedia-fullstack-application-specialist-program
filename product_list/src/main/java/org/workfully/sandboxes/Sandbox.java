package org.workfully.sandboxes;

import org.json.JSONArray;
import org.json.JSONObject;
import org.workfully.controlers.ProductController;
import org.workfully.utilities.RestController;
import org.workfully.view.ProductList;

/**
 * Hello world!
 *
 */
public class Sandbox {

    public static JSONObject json = new JSONObject((RestController.getBody("https://dummyjson.com/products")));
    public static JSONArray products = json.getJSONArray("products");
           

    public static void main(String[] args) {

        ProductController productController = new ProductController();

        

        ProductList productList = new ProductList(productController.generateProductList(products));
        
        //System.out.println(productList.getProductList());
        productList.presentAllProducts();

    }
}
