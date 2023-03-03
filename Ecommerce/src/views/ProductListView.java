package views;

import controllers.ProductController;
import models.Product;

import java.util.ArrayList;

public class ProductListView {

    private ArrayList<Product> products;
    private ProductController controller;


    public void showList(){
        controller = new ProductController();
        products = controller.getAll(1);
    }


    //show in some way
}
