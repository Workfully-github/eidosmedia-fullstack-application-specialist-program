import java.util.ArrayList;

public class MostExpensiveFromArray {
    public static void main (String[] args) {

        double[] list = {74.46, 63.99, 10.57, 81.37};

        ArrayList<Double> valuesArray = new ArrayList<Double>();

        for (int j = 0; j < list.length; j ++) {
            valuesArray.add(list[j]);
        }

        double mostExpensive = 0;

        for(int i = 0; i < valuesArray.size(); i++) {
            if(valuesArray.get(i) > mostExpensive) {
                mostExpensive = valuesArray.get(i);
            }
        }

        System.out.println(mostExpensive);
    }
}
