package Views;

import java.util.ArrayList;

import Models.Product;

public class ProductView {

    

    

    public static void display(ArrayList<Product> products) {
        // int productIndex = 1;
        for(Product product : products) {
            // System.out.println("\n[" + productIndex + "]~~--------------------------------------------------------------------------------------------------------------------------+\n" + 
            System.out.println("\n[" + product.getId() + "]~~--------------------------------------------------------------------------------------------------------------------------+\n" + 
                //  "ID:                " + product.getId() + "\n" +
                 "Title:                " + product.getTitle() + "\n" +
                 "Description:          " + product.getDescription() + "\n$" +
                 "Price:                " + product.getPrice() +
                 "DiscountPercentage:   " + product.getDiscountPercentage() + "\n" +
                 "Rating:               " + product.getRating() + "\n" +
                 "Stock:                " + product.getStock() + "\n" +
                 "Brand:                " + product.getBrand() + "\n" +
                 "Category:             " + product.getCategory() + "\n" +
                 "Thumbnail:            " + product.getThumbnail() + "\n");
                 for(String image : product.getImages()){
                     System.out.println(image + "\n");
                 }
                // productIndex++;
        }
            
    }
    

}
