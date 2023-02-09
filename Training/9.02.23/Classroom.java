import java.util.Arrays;

public class Classroom {
    
    public static void main (String[] args) {
        String[] students = {"Hugo", "Ricardo", "Sidi", "Abderraouf"};
        double[] mathScores = new double[4];
        mathScores[0] = 94.5;
        mathScores[2] = 76.8;

        System.out.println("There are " + students.length + " in the classroom");
        System.out.println(Arrays.toString(students));
    }
}