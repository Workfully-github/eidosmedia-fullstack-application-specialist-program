import java.util.ArrayList;
import java.util.HashMap;

public class SchoolReport {
    public static void main (String[] args) {        
        HashMap<Integer, ArrayList<Integer>> notesMonth = new HashMap<>() {
            {
                put(1, new ArrayList<Integer>() {
                    {
                        add(15);
                        add(16);
                        add(13);
                    }
                });
                put(2, new ArrayList<Integer>() {
                    {
                        add(14);
                        add(18);
                    }
                });
                put(3, new ArrayList<Integer>() {
                    {
                        add(13);
                    }
                });
                put(4, new ArrayList<Integer>() {
                    {
                        add(14);
                        add(17);
                        add(13);
                    }
                });
                put(5, new ArrayList<Integer>() {
                    {
                        add(9);
                        add(16);
                        add(13);
                    }
                });
                put(6, new ArrayList<Integer>() {
                    {
                        add(15);
                        add(11);
                        add(12);
                    }
                });
                put(7, new ArrayList<Integer>() {
                    {
                        add(15);
                        add(20);
                        add(13);
                    }
                });
                put(8, new ArrayList<Integer>() {
                    {
                        add(15);
                        add(1);
                    }
                });
                put(9, new ArrayList<Integer>() {
                    {
                        add(17);
                        add(20);
                        add(19);
                    }
                });
                put(10, new ArrayList<Integer>() {
                    {
                        add(11);
                        add(20);
                        add(17);
                    }
                });
                put(11, new ArrayList<Integer>() {
                    {
                        add(15);
                        add(15);
                        add(13);
                    }
                });
                put(12, new ArrayList<Integer>() {
                    {
                        add(15);
                        add(10);
                        add(12);
                    }
                });
            }
        };

        int sum = 0;
        int maxNote = 0;
        int minNote = 20;

        for (int i = 1; i <= notesMonth.size(); i++) {
            sum = 0;
            for (int j = 0; j < notesMonth.get(i).size(); j++) {
                sum += notesMonth.get(i).get(j);
                
                if (notesMonth.get(i).get(j) > maxNote) {
                    maxNote = notesMonth.get(i).get(j);
                }

                if (notesMonth.get(i).get(j) < minNote) {
                    minNote = notesMonth.get(i).get(j);
                }
            }
            System.out.println("The average for the month " + i + " is " +  sum / notesMonth.get(i).size());                               
        }
        System.out.println("The best note overall was " +  maxNote);                               
        System.out.println("The worst note overall was " +  minNote);                               
    }
}

