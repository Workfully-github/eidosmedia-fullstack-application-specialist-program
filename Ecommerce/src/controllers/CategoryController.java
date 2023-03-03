package controllers;

import http.RestController;
import models.Category;

public class CategoryController {

    RestController rest = new RestController();

    public void getAll(int page){
        String response = rest.get(Category.ENDPOINT,page);


    }


}
