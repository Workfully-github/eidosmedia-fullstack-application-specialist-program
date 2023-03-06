package Models;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import Controllers.NavigationsController;

public class Product {
    private int id, stock;
    private Double price, discountPercentage, rating;
    private String title, description, brand, category, thumbnail;
    private ArrayList<String> images = new ArrayList<>();
    public static ArrayList<Product> products = new ArrayList<>();

    public Product( JSONObject product ){
        this.id = product.getInt("id");
        this.title = product.getString("title");
        this.description = product.getString("description");
        this.price = product.getDouble("price");
        this.discountPercentage = product.getDouble("discountPercentage");
        this.rating = product.getDouble("rating");
        this.stock = product.getInt("stock");
        this.brand = product.getString("brand");
        this.category = product.getString("category");
        this.thumbnail = product.getString("thumbnail");
        this.images = setImages(product.getJSONArray("images"));
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public double getRating() {
        return rating;
    }

    public int getStock() {
        return stock;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    private ArrayList<String> setImages(JSONArray images) {
        ArrayList<String> temp = new ArrayList<>();
        for(int i = 0; i < images.length(); i++){
            temp.add(images.getString(i));
        }
        return temp;
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static ArrayList<Product> getProducts(int page) {
        ArrayList<Product> tempProducts = new ArrayList<>();
        int limit = NavigationsController.getLimit();
        int skip = NavigationsController.getSkip();
        for(int i = skip; i < limit; i++){
            tempProducts.add(products.get(i));
        }
        return tempProducts;
    }

    

    

     public static ArrayList<Product> listOut(JSONArray productsJsonArr){
        ArrayList<Product> products = new ArrayList<>();
        for(int i = 0; i < productsJsonArr.length(); i++){
            products.add(new Product(productsJsonArr.getJSONObject(i)));
        }
        return products;
    }

    // public static ArrayList<Product> listOut(JSONObject productObj){
    //     ArrayList<Product> products = new ArrayList<>();
    //     products.add(new Product(productObj));
    //     return products;
    // }
}