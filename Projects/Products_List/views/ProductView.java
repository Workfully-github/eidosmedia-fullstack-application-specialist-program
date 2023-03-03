package Projects.Products_List.views;

import java.io.IOException;
import java.text.ParseException;

import Projects.Products_List.controllers.ProductController;
import Projects.Products_List.models.Product;

public class ProductView {
    
    private Product product;
    private ProductController productController;
    
    public void showSingleProduct(int id) throws IOException, ParseException {

        productController = new ProductController();
        product = productController.getSingleProduct(id, 1);

        System.out.println("-------------------------------------------------------");
        System.out.println("PRODUCT DETAIL:");
        System.out.println("\n");

        System.out.println("ID: " + product.getId());
        System.out.println("Title: " + product.getTitle());
        System.out.println("Description: " + product.getDescription());
        System.out.println("Price: " + product.getPrice());
        System.out.println("Discount Percentage: " + product.getDiscountPercentage());
        System.out.println("Rating: " + product.getRating());
        System.out.println("Stock: " + product.getStock());
        System.out.println("Brand: " + product.getBrand());
        System.out.println("Category: " + product.getCategory());
        System.out.println("Thumbnail: " + product.getThumbnail());
        System.out.println("Images:");
        for (int j = 0; j < product.getImages().size(); j++) {
               System.out.println(product.getImages().get(j));
        }

        System.out.println("-------------------------------------------------------");
        System.out.println("\n");
    }
}
