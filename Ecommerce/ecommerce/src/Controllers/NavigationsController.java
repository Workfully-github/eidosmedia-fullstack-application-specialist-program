package Controllers;

public class NavigationsController {
    public static int skip = 0;
    public static int limit = 30;
    public static int currentPage = 1;

    public static void next() {
        if (currentPage * limit > 100)
            return;
        currentPage++;
    }

    public static void back() {
        currentPage--;
    }

    public static String pagetranslator(int pageNum) {
        pageNum--;
        return "?skip=" + (limit * pageNum) + "&limit=" + limit;
    }

}
