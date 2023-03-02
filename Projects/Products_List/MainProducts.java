package Projects.Products_List;

import java.io.IOException;
import java.text.ParseException;

import Projects.Products_List.views.ChangePageDialog;
import Projects.Products_List.views.ProductListView;
import Projects.Products_List.views.ProductView;
import Projects.Products_List.views.SearchBarDialog;
import Projects.Products_List.views.SearchBarView;
import Projects.Products_List.views.SeeDetailDialog;
import Projects.Products_List.views.SingleProductDialog;

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






        /* SingleProductDialog singleProductDialog = new SingleProductDialog();

        ProductView productView = new ProductView();
        productView.showSingleProduct(singleProductDialog.chooseSingleProduct());

        ChangePageDialog changePageDialog = new ChangePageDialog();
        changePageDialog.choosePage(skip); */
