package MostExpensive;
import java.util.ArrayList;

public class MostExpensiveArray {
    public static void main(String[] args) {
        double[] listExpensives = {99.99, 63.99, 10.57, 81.37};
        ArrayList<Double> list = new ArrayList<Double>();
        for (double exp : listExpensives)
        list.add(exp);

        double mostExpensive = 0.;
        for(int i=0; i < list.size(); i++){
            if(mostExpensive<list.get(i)){
                mostExpensive = list.get(i);
            }            
        }
        System.out.println("the mostExpensive value is: " + mostExpensive);
    }
    
}
