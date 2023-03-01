package org.workfully.view;

import java.util.ArrayList;
import java.util.HashMap;

import org.workfully.models.Product;

public class ProductList {

    HashMap<Integer, Product> productListByIndex;
    ArrayList<Product> productList;

    public ProductList(ArrayList<Product> productList) {
        this.productList = productList;
        this.productListByIndex = new HashMap<Integer, Product>();
        
        /*
         * Populates the HashMap with the Product List
         * So we can access products by Index if needed
         */
        for (Product product : productList) {
            productListByIndex.put(product.getId(), product);
        }
    }

    public HashMap<Integer, Product> getProductListByIndex() {
        return productListByIndex;
    }

    public void setProductListByIndex(HashMap<Integer, Product> productListByIndex) {
        this.productListByIndex = productListByIndex;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }



    public void presentAllProducts() {
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

}
