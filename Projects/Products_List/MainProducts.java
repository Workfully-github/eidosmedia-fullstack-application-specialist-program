package Projects.Products_List;

import java.io.IOException;
import java.text.ParseException;

import Projects.Products_List.views.ProductListView;
import Projects.Products_List.views.StartingDialog;

public class MainProducts {
    
    public static void main(String[] args) throws IOException, ParseException {

        initialize();

    }

    public static void initialize() throws IOException, ParseException  {
        
        /* ProductListView productListView = new ProductListView();
        productListView.showList(1); */
        
        StartingDialog start = new StartingDialog();
        start.initiateDialog();
    }
}
