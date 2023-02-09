import java.util.ArrayList;

public class SchoolReport {

    // 20 different notes

    // from 1 - 10

    // make average

    public static void main(String[] args) {

        int totalSum = 0;
        int average = 0;

        ArrayList<Integer> collectionOfNotes = new ArrayList<>() {
            {
                add(5);
                add(7);
                add(3);
                add(4);
                add(4);
                add(4);
                add(4);
                add(9);
                add(10);
                add(1);
                add(2);
            }
        };

        for (Integer number : collectionOfNotes) {
            totalSum += number;
        }

        average = totalSum / collectionOfNotes.size();

        System.out.println(average);

    }
}