package Projects.Products_List.models;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Product {
    
    private int id, price, stock;
    private String title, description, brand, category, thumbnail;
    private double discountPercentage, rating;
    private ArrayList<String> images;
    private JSONObject json;

    public static final String ENDPOINT = "/products";
    public static final String KEY_PRODUCTS = "products";

    public Product(JSONObject json) {
        this.json = json;
        id = json.getInt("id");
        price = json.getInt("price");
        stock = json.getInt("stock");
        title = json.getString("title");
        description = json.getString("description");
        brand = json.getString("brand");
        category = json.getString("category");
        thumbnail = json.getString("thumbnail");
        discountPercentage = json.getDouble("discountPercentage");
        rating = json.getDouble("rating");
        images = getAllImages(json.getJSONArray("images"));
    }

    public static ArrayList<Product> createListProducts(JSONArray array) {
        
        ArrayList<Product> productsArray = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            productsArray.add(new Product(array.getJSONObject(i)));
        }
        return productsArray;
    }

    public static Product createSingleProduct(JSONObject object) {
        return new Product(object);
    }
    
    private ArrayList<String> getAllImages(JSONArray jsonArray) {

        ArrayList<String> allImages = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            allImages.add(jsonArray.getString(i));
        }
        
        return allImages;
    }

    public String getBrand() {
        return brand;
    }
    public String getCategory() {
        return category;
    }
    public String getDescription() {
        return description;
    }
    public double getDiscountPercentage() {
        return discountPercentage;
    }
    public int getId() {
        return id;
    }
    public ArrayList<String> getImages() {
        return images;
    }
    public int getPrice() {
        return price;
    }
    public double getRating() {
        return rating;
    }
    public int getStock() {
        return stock;
    }
    public String getThumbnail() {
        return thumbnail;
    }
    public String getTitle() {
        return title;
    }
}
