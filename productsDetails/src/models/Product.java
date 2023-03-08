package models;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Product {
    private int id;
    private String title;
    private String description;
    private double price;
    private double discountPercentage;
    private double rating;
    private int stock;
    private String brand;
    private String category;
    private String thumbnail;
    private List<String> images;

    public static final String ENDPOINT = "/products";
    public static final String KEY_PRODUCTS = "products";

    public Product(int id, String title, String description, double price, double discountPercentage, double rating,
                   int stock, String brand, String category, String thumbnail, List<String> images) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.rating = rating;
        this.stock = stock;
        this.brand = brand;
        this.category = category;
        this.thumbnail = thumbnail;
        this.images = images;
    }

    public Product(JSONObject jsonObject) {
        this.id = jsonObject.getInt("id");
        this.title = jsonObject.getString("title");
        this.description = jsonObject.getString("description");
        this.price = jsonObject.getDouble("price");
        this.discountPercentage = jsonObject.getDouble("discountPercentage");
        this.rating = jsonObject.getDouble("rating");
        this.stock = jsonObject.getInt("stock");
        this.brand = jsonObject.getString("brand");
        this.category = jsonObject.getString("category");
        this.thumbnail = jsonObject.getString("thumbnail");
        this.images = new ArrayList<>();
        JSONArray jsonList = jsonObject.getJSONArray("images");
        for(int i=0; i<jsonList.length(); i++){
            this.images.add(jsonList.get(i).toString());
        }
    }

    public static List<Product> getList(JSONArray jsonArray){
        List<Product> listProduct = new ArrayList();
        for(int i=0; i<jsonArray.length(); i++){
            listProduct.add(new Product(jsonArray.getJSONObject(i)));
        }

        return listProduct;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }


    @Override
    public String toString() {
        return "Product :" +
                "\n-- id=" + id +
                "\n--  title='" + title + '\'' +
                "\n--  description='" + description + '\'' +
                "\n--  price=" + price +
                "\n--  discountPercentage=" + discountPercentage +
                "\n--  rating=" + rating +
                "\n--  stock=" + stock +
                "\n--  brand='" + brand + '\'' +
                "\n--  category='" + category + '\'' +
                "\n--  thumbnail='" + thumbnail + '\'' +
                "\n--  images=" + images +
                '\n';
    }
}
