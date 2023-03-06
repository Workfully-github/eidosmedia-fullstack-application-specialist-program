package Controllers;

public class NavigationsController {
    public static int  skip = 0;
    public static int  limit = 30;
    public static int  currentPage = 1;

    public static void next() {
        currentPage++;
        // skip = (currentPage - 1) * limit;  
        setSkip((currentPage - 1) * limit);  

    }

    
    public static void back() {
        limit = 30;
        setCurrentPage(currentPage - 1);
        setSkip((currentPage - 1) * limit);  
    }

    public static int getLimit() {
        return limit;
    }
    
    public static int getSkip() {
        return skip;
    }

    public static void setSkip(int newskip) {
        NavigationsController.skip = newskip;
    }

    public static void setLimit(int newlimit) {
        NavigationsController.limit = newlimit;
    }

    public static void setCurrentPage(int newcurrentPage) {
        NavigationsController.currentPage = newcurrentPage;
    }

    public static int getCurrentPage() {
        return currentPage;
    }
}
