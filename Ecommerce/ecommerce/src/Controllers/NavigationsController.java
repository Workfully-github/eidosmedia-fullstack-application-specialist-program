package Controllers;

public class NavigationsController {
    public static int productsPerPage = 80;
    public static int skip = 0;
    public static int limit = productsPerPage;



    public static void next() {
        if(skip + productsPerPage > 100) {limit = 0; return;}
        skip += productsPerPage;
    }

    public static void back() {
        if(skip - productsPerPage < 0) skip = 0;
        skip -= productsPerPage;
        limit = productsPerPage;
    }
}
