import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GradesAverage {
    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> yearTable = new HashMap<Integer, List<Integer>>();
        
        //jan
        List<Integer> jan = new ArrayList<Integer>();
        jan.add(12);
        jan.add(13);

        //feb
        List<Integer> feb = new ArrayList<Integer>();
       feb.add(12);
       feb.add(18);

       //mars
       List<Integer> mars = new ArrayList<Integer>();
       mars.add(15);
       mars.add(13);
       mars.add(16);

       //april
       List<Integer> april = new ArrayList<Integer>();
       april.add(14);
       april.add(13);

       //mai
       List<Integer> mai = new ArrayList<Integer>();
       mai.add(12);
       mai.add(18);

       //jun
       List<Integer> jun = new ArrayList<Integer>();
       jun.add(15);
       jun.add(17);
       jun.add(16);

       //jul
       List<Integer> jul = new ArrayList<Integer>();
       jul.add(12);
       jul.add(13);

       //aug
       List<Integer> aug = new ArrayList<Integer>();
       aug.add(12);
       aug.add(8);

       //sep
       List<Integer> sep = new ArrayList<Integer>();
       sep.add(12);

       //oct
       List<Integer> oct = new ArrayList<Integer>();
       oct.add(12);
       oct.add(18);

       //nov
       List<Integer> nov = new ArrayList<Integer>();
       nov.add(12);
       nov.add(17);

       //dec
       List<Integer> dec = new ArrayList<Integer>();
       dec.add(12);
       dec.add(14);
       dec.add(15);
        
       //Putting values in HashMap
       yearTable.put(1, jan);
       yearTable.put(2, feb);
       yearTable.put(3, mars);
       yearTable.put(4, april);
       yearTable.put(5, mai);
       yearTable.put(6, jun);
       yearTable.put(7, jul);
       yearTable.put(8, aug);
       yearTable.put(9, sep);
       yearTable.put(10, oct);
       yearTable.put(11, nov);
       yearTable.put(12, dec);

       int monthSumOfGrades = 0;
       int monthAvg = 0;

       int yearSumOfMonthAvg = 0;
       int YearAvg = 0;

       int bestMonthNote = 0;
       int worstMonthNote = 20;
       int bestMonth = 0;
       int worstMonth = 20;

       for(int month = 1; month <= 12; month++){
            monthSumOfGrades = 0;
            for(int grade = 0; grade < yearTable.get(month).size(); grade++){
                monthSumOfGrades += yearTable.get(month).get(grade);
            }

            monthAvg = monthSumOfGrades / yearTable.get(month).size();

            if(bestMonthNote < monthAvg){
                bestMonthNote = monthAvg;
                bestMonth = month;
            }
            
            if(worstMonthNote > monthAvg){
                worstMonthNote = monthAvg;
                worstMonth = month;
            }
            yearSumOfMonthAvg += monthAvg; 
            System.out.println("your average for month number " + month + " is " + monthAvg);
       }
       YearAvg = yearSumOfMonthAvg / 12;
       System.out.println("your annual average is " + YearAvg);
       System.out.println("Your best month is: " + bestMonth);
       System.out.println("Your worst month is: " + worstMonth);


    }
}
