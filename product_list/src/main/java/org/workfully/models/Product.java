package org.workfully.models;

import java.util.ArrayList;

import org.json.JSONObject;

public class Product {

    private int id;
    private String title;
    private String description;
    private int price;
    private float discountPercentage;
    private float rating;
    private int stock;
    private String brand;
    private String category;
    private String thumbnail;
    private ArrayList<String> images;

    @SuppressWarnings("unused")
    public Product(final JSONObject product) {
        this.id = product.getInt("id");
        this.title = product.getString("title");
        this.description = product.getString("description");
        this.price = product.getInt("price");
        this.discountPercentage = product.getFloat("discountPercentage");
        this.rating = product.getFloat("rating");
        this.stock = product.getInt("stock");
        this.brand = product.getString("brand");
        this.category = product.getString("category");
        this.thumbnail = product.getString("thumbnail");
        this.images = new ArrayList<String>() {
            {
                /*
                 * Adds array of images from Json to ArrayList
                 */
                for (Object string : product.getJSONArray("images")) {
                    int counter = 0;
                    add(product.getJSONArray("images").getString(counter));
                    counter++;
                }
            }
        };
    }

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
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

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Product: \n" + 
        "Id: " + id + "\n" +
        "Title: " + title + "\n" +
        "Description: " + description + "\n" + 
        "Price: " + price + "\n" +
        "DiscountPercentage: " + discountPercentage + "\n" + "Rating: " + rating + "\n" + 
        "Stock: " + stock + "\n" + 
        "Brand: " + brand + "\n" + 
        "Category: " + category + "\n" + 
        "Thumbnail: " + thumbnail + "\n" + 
        "Images: " + images + "\n";
    }
}
