package Projects.Products_List.controllers;

public class PageController {
    
    private JsonController json;
    private static int pageNumber = 1;

    public PageController() {
        this.json =  new JsonController();
    }

    
    // Preciso de saber:
    /*
     * - se é a primeira pagina
     * - em que pagina estou
     * - qual é a proxima
     * - qual a anterior
     * - quantas paginas faltam
     */
    
    public boolean firstPage() {
        if(getPageNumber() == 1) return true;
        else return false;
    }

    public static int getPageNumber() {
        return pageNumber;
    }

    public static void nextPage() {
        pageNumber = pageNumber + 1;
    }

    public static void previousPage() {
        pageNumber = pageNumber - 1;
    }

    // TODO
    public int pagesLeft() {

        return 0;
    }


}
