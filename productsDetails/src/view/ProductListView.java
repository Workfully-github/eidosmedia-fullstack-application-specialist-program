package view;

import controllers.CategoryController;
import controllers.ProductController;
import http.HttpController;
import models.Product;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ProductListView {

    ProductController productController = new ProductController();
    CategoryController categoryController = new CategoryController();

    public void showAllProduct(String urlToAdd) throws IOException {
        List<Product> productList = productController.getAllProduct(urlToAdd);
        if(productList.isEmpty()){
            System.out.println("the search doesn't match any product");
            System.out.println("---------------------------------------------------");
        }
        for(int i=0; i<productList.size(); i++) {
            System.out.println(productList.get(i).toString());
        }
    }
    public void showAllProduct() throws IOException {
        List<Product> productList = productController.getAllProduct();
        if(productList.isEmpty()){
            System.out.println("the search doesn't match any product");
            System.out.println("---------------------------------------------------");
        }
        for(int i=0; i<productList.size(); i++) {
            System.out.println(productList.get(i).toString());
        }
    }

    public void showSearch(String search) throws IOException {
        List<Product> productList = productController.getSearch(search);
        if(productList.isEmpty()){
            System.out.println("the search doesn't match any product");
            System.out.println("---------------------------------------------------");
        }

        for(int i=0; i<productList.size(); i++) {
            System.out.println(productList.get(i).toString());
        }
    }

    public void showListOfCategories() throws IOException {
        List<String> categories = categoryController.getListOfCategories();
        for(int i=0; i<categories.size(); i++) {
            System.out.println(categories.get(i).toString());
        }
    }

    public void showAllProductWithPagination(String url, int skip, int limit) throws IOException {
        int skip0 = skip;
        int limit0 = limit;
        this.showAllProduct("?skip=" + skip0 + "&limit=" + limit0);
        System.out.print("this page is for skip: " + skip0 + "and limit: " + limit0);
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter ...\n |\"search\" to search a Product,\n |\"details\" to see a Product, \n |\"next\" for next page, \n |\"prev\" for preview page,\n | \"cat\" to have the list of categories, \n |\"end\" to logout : \n");
        String str = sc.nextLine();
        while(!str.contains("end")){
            if(str.contains("next")){
                skip0 += limit0;
                this.showAllProduct( "?skip=" + skip0 + "&limit=" + limit0);
                System.out.print("this page is for skip: " + skip0 + " and limit: " + limit0 + "\n");
            }
            if(str.contains("prev")){
                skip0 -= limit0;
                this.showAllProduct("?skip=" + skip0 + "&limit=" + limit0);
                System.out.print("this page is for skip: " + skip0 + " and limit: " + limit0 +"\n");
            }
            else if(str.contains("details")){
                ProductView productView = new ProductView();
                System.out.print("Enter the product id: \n");
                String id = sc.nextLine();
                productView.showProductById( id);
            }
            else if(str.contains("search")){
                System.out.print("Enter search value: \n");
                String search = sc.nextLine();
                this.showSearch(search);
            }
            else if(str.contains("cat")){
                this.showListOfCategories();
                System.out.print("Enter a category or \"none\" to go back : \n");

                String search = sc.nextLine();
                if(!search.equals("none")){
                    this.showAllProduct("/category/" + search);
                    System.out.print("All product for category : " + search);
                }
            }
            System.out.print("\nEnter ...\n |\"search\" to search a Product,\n |\"details\" to see a Product, \n |\"next\" for next page, \n |\"prev\" for preview page,\n | \"cat\" to have the list of categories, \n |\"end\" to logout : \n");
            str = sc.nextLine();
        }
    }

}
