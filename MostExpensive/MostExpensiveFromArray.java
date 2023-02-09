import java.util.ArrayList;

public class MostExpensiveFromArray {

    public static void main(String[] args) {

        double[] doubleArray = { 74.46, 63.99, 10.57, 81.37 };

        ArrayList<Double> doubleArrayList = new ArrayList<>();

        for (double decimalNumberInTheArray : doubleArray) {

            doubleArrayList.add(decimalNumberInTheArray);
        }

        double mostExpensive = 0d;

        for (Double decimalNumber : doubleArrayList) {

            if (decimalNumber > mostExpensive) {
                mostExpensive = decimalNumber;
            }
        }

        System.out.println("Most Expensive: " + mostExpensive);
    }

}
