package NotesAverage;
import java.util.ArrayList;

public class NotesAverage {
    public static void main(String[] args) {
        double[] listExpensives = {99.99, 63.99, 10.57, 81.37};
        ArrayList<Double> list = new ArrayList<Double>();
        for (double exp : listExpensives)
        list.add(exp);

        double sum = 0.;
        for(int i=0; i < list.size(); i++){
            sum+=list.get(i);          
        }

        System.out.println("the average value is: " + sum/list.size());
    }
    
}
