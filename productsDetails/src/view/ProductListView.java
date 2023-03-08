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
        CommandLineTable st = new CommandLineTable();
        st.setShowVerticalLines(true);
        st.setHeaders("Id", "Title", "Description", "Price", "Discount Percentage", "Rating", "Stock", "Brand", "Category");
        Product p;
        for(int i=0; i<productList.size(); i++) {
            p = productList.get(i);
            st.addRow(p.getId()+"", p.getTitle(),p.getDescription(),p.getPrice()+"",p.getDiscountPercentage()+"",p.getRating()+"",p.getStock()+"",p.getBrand(),p.getCategory());
        }
        st.print();
    }
    public void showAllProduct() throws IOException {
        List<Product> productList = productController.getAllProduct();
        if(productList.isEmpty()){
            System.out.println("the search doesn't match any product");
            System.out.println("---------------------------------------------------");
        }
        CommandLineTable st = new CommandLineTable();
        st.setShowVerticalLines(true);
        st.setHeaders("Id", "Title", "Description", "Price", "Discount Percentage", "Rating", "Stock", "Brand", "Category");
        Product p;
        for(int i=0; i<productList.size(); i++) {
            p = productList.get(i);
            st.addRow(p.getId()+"", p.getTitle(),p.getDescription(),p.getPrice()+"",p.getDiscountPercentage()+"",p.getRating()+"",p.getStock()+"",p.getBrand(),p.getCategory());
        }
        st.print();
    }

    public void showAllProductIdAndName() throws IOException {
        List<Product> productList = productController.getAllProduct();
        if(productList.isEmpty()){
            System.out.println("the search doesn't match any product");
            System.out.println("---------------------------------------------------");
        }
        CommandLineTable st = new CommandLineTable();
        st.setShowVerticalLines(true);
        st.setHeaders("Id", "Product title");
        for(int i=0; i<productList.size(); i++) {
            st.addRow(productList.get(i).getId()+"", productList.get(i).getTitle());
        }
        st.print();
    }
    public void showAllProductIdAndName(String urlToAdd) throws IOException {
        List<Product> productList = productController.getAllProduct(urlToAdd);
        if(productList.isEmpty()){
            System.out.println("the search doesn't match any product");
            System.out.println("---------------------------------------------------");
        }
        CommandLineTable st = new CommandLineTable();
        st.setShowVerticalLines(true);
        st.setHeaders("Id", "Product title");
        for(int i=0; i<productList.size(); i++) {
            st.addRow(productList.get(i).getId()+"", productList.get(i).getTitle());
        }
        st.print();
    }

    public void showSearch(String search) throws IOException {
        List<Product> productList = productController.getSearch(search);
        if(productList.isEmpty()){
            System.out.println("the search doesn't match any product");
            System.out.println("---------------------------------------------------");
        }

        CommandLineTable st = new CommandLineTable();
        st.setShowVerticalLines(true);
        st.setHeaders("Id", "Title", "Description", "Price", "Discount Percentage", "Rating", "Stock", "Brand", "Category");
        Product p;
        for(int i=0; i<productList.size(); i++) {
            p = productList.get(i);
            st.addRow(p.getId()+"", p.getTitle(),p.getDescription(),p.getPrice()+"",p.getDiscountPercentage()+"",p.getRating()+"",p.getStock()+"",p.getBrand(),p.getCategory());
        }
        st.print();
    }

    public void showListOfCategories() throws IOException {
        List<String> categories = categoryController.getListOfCategories();
        CommandLineTable st = new CommandLineTable();
        st.setShowVerticalLines(true);
        st.setHeaders("Category");
        for(int i=0; i<categories.size(); i++) {
            st.addRow(categories.get(i));
        }
        st.print();
    }

    public void showByCategoryFilter(String urlToAdd) throws IOException {
        List<Product> productList = productController.filterByCategory(urlToAdd);
        if(productList.isEmpty()){
            System.out.println("the search doesn't match any product");
            System.out.println("---------------------------------------------------");
        }
        CommandLineTable st = new CommandLineTable();
        st.setShowVerticalLines(true);
        st.setHeaders("Id", "Title", "Description", "Price", "Discount Percentage", "Rating", "Stock", "Brand", "Category");
        Product p;
        for(int i=0; i<productList.size(); i++) {
            p = productList.get(i);
            st.addRow(p.getId()+"", p.getTitle(),p.getDescription(),p.getPrice()+"",p.getDiscountPercentage()+"",p.getRating()+"",p.getStock()+"",p.getBrand(),p.getCategory());
        }
        st.print();
    }

    public void showByStockFilter(int stock) throws IOException {
        List<Product> productList = productController.filterByStock(stock);
        if(productList.isEmpty()){
            System.out.println("the search doesn't match any product");
            System.out.println("---------------------------------------------------");
        }
        CommandLineTable st = new CommandLineTable();
        st.setShowVerticalLines(true);
        st.setHeaders("Id", "Title", "Description", "Price", "Discount Percentage", "Rating", "Stock", "Brand", "Category");
        Product p;
        for(int i=0; i<productList.size(); i++) {
            p = productList.get(i);
            st.addRow(p.getId()+"", p.getTitle(),p.getDescription(),p.getPrice()+"",p.getDiscountPercentage()+"",p.getRating()+"",p.getStock()+"",p.getBrand(),p.getCategory());
        }
        st.print();
    }

    public void showAllProductWithPagination(int skip, int limit) throws IOException {
        int skip0 = skip;
        int limit0 = limit;
        //this.showAllProduct("?skip=" + skip0 + "&limit=" + limit0);
        this.showAllProductIdAndName("?skip=" + skip0 + "&limit=" + limit0);
        System.out.print("Product list for skip: " + skip0 + " and limit: " + limit0 +"\n");
        Scanner sc = new Scanner(System.in);
        String str = "go";
        while(!str.equals("end")){
            System.out.print("\nChoose by entering ...\n |\"filter\" to filtre\n |\"search\" to search a Product,\n |\"details\" to see a Product details, \n |\"next\" for next page, \n |\"prev\" for preview page,\n | \"cat\" to filter by categories (API) , \n |\"end\" to logout \n## ");
            str = sc.nextLine();
            if(str.equals("next")){
                skip0 += limit0;
                this.showAllProductIdAndName( "?skip=" + skip0 + "&limit=" + limit0);
                System.out.print("Product list for  skip: " + skip0 + " and limit: " + limit0 + "\n");
            }
            else if(str.equals("prev")){
                skip0 -= limit0;
                this.showAllProductIdAndName("?skip=" + skip0 + "&limit=" + limit0);
                System.out.print("Product list for  skip: " + skip0 + " and limit: " + limit0 +"\n");
            }
            else if(str.equals("details")){
                ProductView productView = new ProductView();
                System.out.print("Enter the product id: \n");
                String id = sc.nextLine();
                productView.showProductById( id);
            }
            else if(str.equals("search")){
                System.out.print("Enter search value: \n");
                String search = sc.nextLine();
                this.showSearch(search);
            }
            else if(str.equals("cat")){
                this.showListOfCategories();
                System.out.print("Enter a category or \"none\" to go back : \n");

                String search = sc.nextLine();
                if(!search.equals("none")){
                    this.showAllProduct("/category/" + search);
                    System.out.print("This is all product for category : " + search);
                }
            }
            else if(str.equals("filter")) {
                System.out.print("Filter by :\n | \"cat\" -->category \n | \"sto\" -->stock \n \"none\"--> to go back \n## ");

                String type = sc.nextLine();
                if (type.equals("cat")) {
                    showListOfCategories();
                    System.out.print("choose a category : ");
                    String search = sc.nextLine();
                    if (!search.equals("none")) {
                        this.showByCategoryFilter(search);
                        System.out.print("All product for category : " + search);
                    }
                } else if (type.equals("sto")) {
                    System.out.print("choose a number of stock (-1. to go back) : ");
                    int search = sc.nextInt();
                    if (search != -1) {
                        this.showByStockFilter(search);
                        System.out.print("All product for stock " + search + ".");
                    } else if (search < -1) {
                        System.out.print("Invalid number ");
                    }
                    sc.nextLine();
                }

            }
        }
    }

}
