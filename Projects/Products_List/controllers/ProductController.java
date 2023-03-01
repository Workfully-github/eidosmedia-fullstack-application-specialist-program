package Projects.Products_List.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import Projects.Products_List.models.Product;

public class ProductController {
    
    private JsonController jsonController = new JsonController();
    
    public ArrayList<Product> getAll(int skip, int limit) throws IOException, ParseException {

        JSONArray response = jsonController.getJson(skip, limit);

        return Product.createListProducts(response);
    }

    public Product getSingleProduct(int id) throws IOException, ParseException {

        JSONArray response = jsonController.getJson(0, 100);
        JSONObject object = new JSONObject(); 

        for (int i = 0; i < response.length(); i++) {
            if (response.getJSONObject(i).getInt("id") == id) object = response.getJSONObject(i);
        }

        return Product.createSingleProduct(object);
    }
}
