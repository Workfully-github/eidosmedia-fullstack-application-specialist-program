package org.workfully.models;

import org.json.JSONObject;
import org.w3c.dom.Document;

public class Stats {
    
    private int pageRequests;
    private int allProductsRequests;
    private int productDetailsRequests;
    private int searchRequests;
    private int searchByCategoryRequests;
    private int categoriesRequests;

    public Stats(Document xmlStatsData) {
        this.pageRequests =Integer.parseInt(xmlStatsData.getElementsByTagName("stat").item(0).getTextContent());
        this.allProductsRequests = Integer.parseInt(xmlStatsData.getElementsByTagName("stat").item(1).getTextContent());
        this.productDetailsRequests = Integer.parseInt(xmlStatsData.getElementsByTagName("stat").item(2).getTextContent());
        this.searchRequests = Integer.parseInt(xmlStatsData.getElementsByTagName("stat").item(3).getTextContent());
        this.searchByCategoryRequests = Integer.parseInt(xmlStatsData.getElementsByTagName("stat").item(4).getTextContent());
        this.categoriesRequests = Integer.parseInt(xmlStatsData.getElementsByTagName("stat").item(5).getTextContent());
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