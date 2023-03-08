package org.workfully.models;

public class OperationTracker {

    private int productsCounter;
    private int productCounter;
    private int searchCounter;
    private int searchByCategoryCounter;
    private int getAllProductsCounter;
    private int categoriesCounter;

    public OperationTracker() {
    }

    public OperationTracker(int getProductsCounter, int getProductCounter, int searchCounter,
            int searchByCategoryCounter, int getAllProductsCounter, int categoriesCounter) {
        this.productsCounter = getProductsCounter;
        this.productCounter = getProductCounter;
        this.searchCounter = searchCounter;
        this.searchByCategoryCounter = searchByCategoryCounter;
        this.getAllProductsCounter = getAllProductsCounter;
        this.categoriesCounter = categoriesCounter;
    }

    public int getGetProductsCounter() {
        return productsCounter;
    }

    public void setProductsCounter(int getProductsCounter) {
        this.productsCounter = getProductsCounter;
    }

    public int getProductCounter() {
        return productCounter;
    }

    public void setProductCounter(int getProductCounter) {
        this.productCounter = getProductCounter;
    }

    public int getSearchCounter() {
        return searchCounter;
    }

    public void setSearchCounter(int searchCounter) {
        this.searchCounter = searchCounter;
    }

    public int getSearchByCategoryCounter() {
        return searchByCategoryCounter;
    }

    public void setSearchByCategoryCounter(int searchByCategoryCounter) {
        this.searchByCategoryCounter = searchByCategoryCounter;
    }

    public int getGetAllProductsCounter() {
        return getAllProductsCounter;
    }

    public void setGetAllProductsCounter(int getAllProductsCounter) {
        this.getAllProductsCounter = getAllProductsCounter;
    }

    public int getCategoriesCounter() {
        return categoriesCounter;
    }

    public void setCategoriesCounter(int categoriesCounter) {
        this.categoriesCounter = categoriesCounter;
    }
}
