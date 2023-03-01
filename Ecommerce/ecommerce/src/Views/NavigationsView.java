package Views;

import java.util.Scanner;

import Controllers.NavigationsController;
import Controllers.ProductsController;

public class NavigationsView {
    public static void navigate(){
        Scanner in = new Scanner(System.in);
        if(NavigationsController.skip != 0) System.out.println("Back (0)");
        if(NavigationsController.limit != 0) System.out.println("Next (1)");
    
        int userDecision = in.nextInt();
    
        if(userDecision == 0){
            NavigationsController.back();
            ProductView.display(ProductsController.getProducts("https://dummyjson.com/products", NavigationsController.skip, NavigationsController.limit));
            navigate();
        }else if(userDecision == 1){
            NavigationsController.next();
            ProductView.display(ProductsController.getProducts("https://dummyjson.com/products", NavigationsController.skip, NavigationsController.limit));
            navigate();
        }
        
    }
}
