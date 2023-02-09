import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SchoolReportHashMap {

    public static void main(String[] args) {

        int totalSum = 0;

        int average = 0;

        int bestNote = 0;

        int bestMonthNumber = 0;

        ArrayList<Integer> bestMonthsArray = new ArrayList<>();

        HashMap<Integer, Integer[]> moreNotesInMonth = new HashMap<>() {
            {
                put(1, new Integer[] { 10, 2 });
                put(2, new Integer[] { 1 });
                put(3, new Integer[] { 6 });
                put(3, new Integer[] { 6 });
                put(3, new Integer[] { 6 });
                put(3, new Integer[] { 6, 5 });
                put(3, new Integer[] { 6, 10 });
                put(3, new Integer[] { 6, 9 });
                put(3, new Integer[] { 6, 5 });
                put(3, new Integer[] { 6 });
                put(3, new Integer[] { 6 });
                put(3, new Integer[] { 6 });
            }
        };

        for (Integer key : moreNotesInMonth.keySet()) {
            // Find Average

            for(int i = 0; i < moreNotesInMonth.get(key).length; i++){

            }

/*             totalSum += moreNotesInMonth.get(key);

            if (moreNotesInMonth.get(key) > bestNote) {
                bestNote = moreNotesInMonth.get(key);
            } */
        }




        /////////////////////////////////////////////////////////////////////////////////////

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
                bestMonthNumber = key;
                bestMonthsArray.add(key);
            }

        }

        average = totalSum / notesInMonth.size();

        System.out.println("Average Note: " + average);

        System.out.println("The best Months are: " + bestMonthsArray.toString());

       
    }

}
