package Projects.Products_List;

import java.io.IOException;
import java.text.ParseException;

import Projects.Products_List.views.ProductListView;
import Projects.Products_List.views.SearchBarDialog;
//import Projects.Products_List.views.SeeDetailDialog;

public class MainProducts {
    
    public static void main(String[] args) throws IOException, ParseException {

        initialize(0, 20);

    }

    public static void initialize(int skip, int limit) throws IOException, ParseException  {
        
        ProductListView productListView = new ProductListView();
        productListView.showList(skip, limit);
        
        /* SeeDetailDialog seeDetailDialog = new SeeDetailDialog();
        seeDetailDialog.seeDetail(skip); */

        SearchBarDialog searchBarDialog = new SearchBarDialog();
        searchBarDialog.doSearch(skip, limit);
    }
}
