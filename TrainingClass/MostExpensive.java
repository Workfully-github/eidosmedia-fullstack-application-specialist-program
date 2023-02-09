import java.util.ArrayList;

public class MostExpensive {
    public static void main (String[] args) {

        ArrayList<Double> valuesArray = new ArrayList<Double>();

        valuesArray.add(74.46);
        valuesArray.add(63.99);
        valuesArray.add(10.57);
        valuesArray.add(81.37);

        double mostExpensive = 0;

        for(int i = 0; i < valuesArray.size(); i++) {
            if(valuesArray.get(i) > mostExpensive) {
                mostExpensive = valuesArray.get(i);
            }
        }

        System.out.println(mostExpensive);
    }
}
