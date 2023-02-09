package MostExpensive;
import java.util.ArrayList;

public class MostExpensive {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<Double>();
        list.add(99.99);
        list.add(63.99);
        list.add(10.57);
        list.add(81.37);
        double mostExpensive = 0.;
        for(int i=0; i < list.size(); i++){
            if(mostExpensive<list.get(i)){
                mostExpensive = list.get(i);
            }            
        }
        System.out.println("the mostExpensive value is: " + mostExpensive);
    }
    
}
