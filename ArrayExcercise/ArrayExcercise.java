package ArrayExcercise;
import java.util.ArrayList;

public class ArrayExcercise {

    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<String>();
        students.add("Abdu");
        students.add("Hugo");
        students.add("Sidi");
        students.add("Ricardo");
        students.add(0, "Omar");
        students.add("Abdu");
        System.out.println("1 the arrays is:  " + students);
        students.add(0, "Amine");
        students.add(0, "Omar");

        System.out.println("2 the arrays is:  " + students);

        students.remove("Hugo");
        System.out.println("3 the arrays after remove is:  " + students);

        students.remove("Abdu");
        System.out.println("4 the arrays after remove is:  " + students);

        students.set(0, "Ada");
        System.out.println("5 the arrays after remove is:  " + students);



    }
    
}
