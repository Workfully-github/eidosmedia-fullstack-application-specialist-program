package org.workfully.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "operationTracker")
@XmlAccessorType(XmlAccessType.FIELD)
public class OperationTracker {

    private int pageRequests;
    private int allProductsRequests;
    private int productDetailsRequests;
    private int searchRequests;
    private int searchByCategoryRequests;
    private int categoriesRequests;

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

    public void incrementPageRequests() {
        this.pageRequests++;
    }

    public void incrementAllProductsRequests() {
        this.allProductsRequests++;
    }

    public void incrementProductDetailsRequests() {
        this.productDetailsRequests++;
    }

    public void incrementSearchRequests() {
        this.searchRequests++;
    }

    public void incrementSearchByCategoryRequests() {
        this.searchByCategoryRequests++;
    }

    public void incrementCategoriesRequests() {
        this.categoriesRequests++;
    }
}
