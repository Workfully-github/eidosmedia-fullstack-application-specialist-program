import java.util.ArrayList;

public class MostExpensive {
    public static void main(String[] args) {
        double[] pricesArr = {99.54, 63.99, 15.57, 81.37}; 
        ArrayList<Double>pricesArrList = new ArrayList<Double>();;
        double mostExpensive  = 0;
       
        for(double price : pricesArr){
            pricesArrList.add(price);
        }

        for(double price : pricesArrList){
            if(price > mostExpensive){
                mostExpensive = price;
            }
        }

        System.out.println(mostExpensive);
    }
}
