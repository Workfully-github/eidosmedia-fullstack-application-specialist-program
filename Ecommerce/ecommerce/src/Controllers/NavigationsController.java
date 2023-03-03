package Controllers;

public class NavigationsController {
    public static int  productsPerPage = 30;
    public static int  skip = 0;
    public static int  limit = 30;



    public static void next() {
        if(skip + productsPerPage > 100) {limit = 100 - skip; return;}
        skip += productsPerPage;
    }

    public static void back() {
        if(skip - productsPerPage < 0) {skip = 0; return;};
        skip -= productsPerPage;
        limit = productsPerPage;
    }

    public static String pagetranslator(int pageNum) {
        pageNum--;
        return "?skip=" + (limit * pageNum) + "&limit=" + limit ;
    } 
    
}
