import java.util.ArrayList;

public class MostExpensive {

    public static void main(String[] args) {
        
        ArrayList<Double> decimalNumbers = new ArrayList<>(){
            {
                add(74.46);
                add(63.99);
                add(10.57);
                add(81.37);
            }
        };

        double mostExpensive = 0d;

        for (Double decimalNumber : decimalNumbers) {

            if(decimalNumber > mostExpensive){
                mostExpensive = decimalNumber;
            }
        }

        System.out.println("Most Expensive: " + mostExpensive);

    }
}