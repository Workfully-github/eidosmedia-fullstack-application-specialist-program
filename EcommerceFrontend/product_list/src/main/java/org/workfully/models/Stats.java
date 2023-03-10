package org.workfully.models;
import org.json.JSONObject;
public class Stats {
    
    private int pageRequests;
    private int allProductsRequests;
    private int productDetailsRequests;
    private int searchRequests;
    private int searchByCategoryRequests;
    private int categoriesRequests;
    public Stats(JSONObject statsJson) {
        this.pageRequests = statsJson.getInt("pageRequests");
        this.allProductsRequests = statsJson.getInt("allProductsRequests");
        this.productDetailsRequests = statsJson.getInt("productDetailsRequests");
        this.searchRequests = statsJson.getInt("searchRequests");
        this.searchByCategoryRequests = statsJson.getInt("searchByCategoryRequests");
        this.categoriesRequests = statsJson.getInt("categoriesRequests");
    }
    
    public int getTotalCalls() {
        return pageRequests + allProductsRequests + productDetailsRequests
        + searchRequests + searchByCategoryRequests + categoriesRequests;
    }
    public String percentagePageRequests() {
        return pageRequests / getTotalCalls() + "%";
    }
    public String percentageAllProductsRequests() {
        return allProductsRequests / getTotalCalls() + "%";
    }
    public String percentageProductDetailsRequests() {
        return productDetailsRequests / getTotalCalls() + "%";
    }
    public String percentageSearchRequests() {
        return searchRequests / getTotalCalls() + "%";
    }
    public String percentageSearchByCategoryRequests() {
        return searchByCategoryRequests / getTotalCalls() + "%";
    }
    public String percentageCategoriesRequests() {
        return categoriesRequests / getTotalCalls() + "%";
    }
    public int getPageRequests() {
        return pageRequests;
    }
    public void setPageRequests(int pageRequests) {
        this.pageRequests = pageRequests;
    }
    public int getAllProductsRequests() {
        return allProductsRequests;
    }
    public void setAllProductsRequests(int allProductsRequests) {
        this.allProductsRequests = allProductsRequests;
    }
    public int getProductDetailsRequests() {
        return productDetailsRequests;
    }
    public void setProductDetailsRequests(int productDetailsRequests) {
        this.productDetailsRequests = productDetailsRequests;
    }
    public int getSearchRequests() {
        return searchRequests;
    }
    public void setSearchRequests(int searchRequests) {
        this.searchRequests = searchRequests;
    }
    public int getSearchByCategoryRequests() {
        return searchByCategoryRequests;
    }
    public void setSearchByCategoryRequests(int searchByCategoryRequests) {
        this.searchByCategoryRequests = searchByCategoryRequests;
    }
    public int getCategoriesRequests() {
        return categoriesRequests;
    }
    public void setCategoriesRequests(int categoriesRequests) {
        this.categoriesRequests = categoriesRequests;
    }
    
}
