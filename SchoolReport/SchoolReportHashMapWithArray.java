import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// WORK IN PROGRESS
public class SchoolReportHashMapWithArray {

    public static void main(String[] args) {

        float totalSum = 0f;

        float numberOfNotes = 0f;

        float average = 0.00f;

        float bestNote = 0;

        float worstNote = 10;

        int bestMonthNumber = 0;

        String month = "";

        ArrayList<Integer> bestMonthsArray = new ArrayList<>();

        HashMap<Integer, ArrayList<Integer>> moreNotesInMonth = new HashMap<>() {
            {
                put(1, new ArrayList<Integer>(){ 
                    {
                        add(9);
                        add(10);
                    } 
                });

                put(2, new ArrayList<Integer>(){ 
                    {
                        add(1);
                    } 
                });
            }
        };

        for (Integer key : moreNotesInMonth.keySet()) {

            numberOfNotes += moreNotesInMonth.get(key).size(); // Sums NUMBER of Notes in every key in order to calculate average
            
            for(int i = 0; i < moreNotesInMonth.get(key).size(); i++){

                totalSum += moreNotesInMonth.get(key).get(i);  // Sums ALL the notes

                // find best note
                if(moreNotesInMonth.get(key).get(i) > bestNote){
                    bestNote = moreNotesInMonth.get(key).get(i);
                }

                // find worst note
                if(moreNotesInMonth.get(key).get(i) < worstNote){
                    worstNote = moreNotesInMonth.get(key).get(i);
                }

                // find best month
                if (moreNotesInMonth.get(key).get(i) == bestNote) {
                    bestMonthNumber = key;
                    bestMonthsArray.add(key);
                }
            }

            average = totalSum / numberOfNotes; // Find Average

        }

        // Switch just to transform month number into month name, lots of ways to do this, this was the fastest
        switch (bestMonthNumber) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;    
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;   
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;   
            case 11:
                month = "November";
                break; 
            case 12:
                month = "December";
                break; 
            default:
                break;
        }

        System.out.println("Total Sum: " + totalSum);
        System.out.println("Number Of Notes: " + numberOfNotes);
        System.out.println("Average: " + average);
        System.out.println("Best Note: " + bestNote);
        System.out.println("Worst Note: " + worstNote);
        System.out.println("Best Month: " + month);
        
       
    }

}
