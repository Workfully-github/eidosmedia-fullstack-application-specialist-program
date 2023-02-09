import java.util.ArrayList;
import java.util.HashMap;

public class SchoolReportHashMap {

    public static void main(String[] args) {

        /*
         * First Example with only one value;
         * @see Exercises.SchoolReport.SchoolReportHashMapWithArray.java for full exercise
         */

        int totalSum = 0;

        int average = 0;

        int bestNote = 0;

        ArrayList<Integer> bestMonthsArray = new ArrayList<>();

        HashMap<Integer, Integer> notesInMonth = new HashMap<>() {
            {
                put(1, 9);
                put(2, 1);
                put(3, 6);
                put(4, 1);
                put(5, 5);
                put(6, 9);
                put(7, 1);
                put(8, 8);
                put(9, 4);
                put(10, 5);
                put(11, 3);
                put(12, 5);
            }
        };

        // Find Best Note 
        for (Integer key : notesInMonth.keySet()) {
            // Find Average
            totalSum += notesInMonth.get(key);

            if (notesInMonth.get(key) > bestNote) {
                bestNote = notesInMonth.get(key);
            }
        }

        // Find Best Month
        for (Integer key : notesInMonth.keySet()) {

            if (notesInMonth.get(key) == bestNote) {
                bestMonthsArray.add(key);
            }

        }

        average = totalSum / notesInMonth.size();

        System.out.println("Average Note: " + average);

        System.out.println("The best Months are: " + bestMonthsArray.toString());
        System.out.println("The worst Months are: " + bestMonthsArray.toString());

       
    }

}
