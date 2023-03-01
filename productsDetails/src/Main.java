import view.ProductListView;
import view.ProductView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Home Products!");

        ProductListView productListView = new ProductListView();
        ProductView productView = new ProductView();

        //String url = "https://dummyjson.com/products/1";
        //productView.showProductById(url);

        //String listUrl = "https://dummyjson.com/products";
        //productListView.showAllProduct(listUrl);

        String listUrl0 = "https://dummyjson.com/products";
        productListView.showAllProductWithPagination(listUrl0,30,30);
    }
}