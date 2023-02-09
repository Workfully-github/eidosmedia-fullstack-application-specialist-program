import java.util.ArrayList;
import java.util.HashMap;
import java.util.List; 

public class SchoolReport {
    public static void main (String[] args) {

        /* HashMap<String, Integer> notesMonth = new HashMap<String, Integer>();

        notesMonth.put("January", 14);
        notesMonth.put("February", 15);
        notesMonth.put("March", 17);
        notesMonth.put("April", 14);
        notesMonth.put("June", 11); */
        
        HashMap<String, List<Integer>> notesMonth2 = new HashMap<>();

        List<Integer> notesJan = new ArrayList<>();
        notesJan.add(15);
        notesJan.add(16);
        notesJan.add(13);
        notesMonth2.put("January", notesJan);

        List<Integer> notesFeb = new ArrayList<>();
        notesFeb.add(14);
        notesFeb.add(18);
        notesMonth2.put("February", notesFeb);

        List<Integer> notesMar = new ArrayList<>();
        notesMar.add(16);
        notesMonth2.put("March", notesMar);

        List<Integer> notesApr = new ArrayList<>();
        notesApr.add(11);
        notesApr.add(20);
        notesApr.add(9);
        notesMonth2.put("April", notesApr);

        List<Integer> notesMay = new ArrayList<>();
        notesMay.add(20);
        notesMonth2.put("May", notesMay);

        List<Integer> notesJun = new ArrayList<>();
        notesJun.add(13);
        notesJun.add(19);
        notesMonth2.put("June", notesJun);

        List<Integer> notesJul = new ArrayList<>();
        notesJul.add(11);
        notesJul.add(15);
        notesJul.add(7);
        notesMonth2.put("July", notesJul);

        List<Integer> notesAug = new ArrayList<>();
        notesAug.add(14);
        notesAug.add(13);
        notesAug.add(15);
        notesMonth2.put("August", notesAug);

        List<Integer> notesSep = new ArrayList<>();
        notesSep.add(11);
        notesSep.add(20);
        notesSep.add(9);
        notesMonth2.put("September", notesSep);

        List<Integer> notesOct = new ArrayList<>();
        notesOct.add(11);
        notesMonth2.put("October", notesOct);

        List<Integer> notesNov = new ArrayList<>();
        notesNov.add(11);
        notesNov.add(20);
        notesMonth2.put("November", notesNov);

        List<Integer> notesDec = new ArrayList<>();
        notesDec.add(20);
        notesDec.add(9);
        notesMonth2.put("December", notesDec);

        System.out.println(notesMonth2);


        int sum = 0;

        for (int i = 0; i < notes.size(); i++) {
            sum += notes.get(i);
        }

        double averageNote = sum/ notes.size(); */

       /*  System.out.println(notes); */
        /* System.out.println(notesMonth); */
    }
}
