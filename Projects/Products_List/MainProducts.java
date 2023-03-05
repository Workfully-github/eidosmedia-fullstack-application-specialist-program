package Projects.Products_List;

import Projects.Products_List.views.StartingDialog;

public class MainProducts {
    
    public static void main(String[] args) {
        initialize();
    }

    public static void initialize() {
        StartingDialog start = new StartingDialog();
        start.initiateDialog();
    }
}
