import java.util.ArrayList;

class Classroom {
    public static void main(String[] args) {
        String[] students = {"Abderraouf", "Ricardo", "Sidi", "Hugo"};
        double[] mathScores = new double[4];
        
        mathScores[0] = 94.5;
        mathScores[2] = 76.8;
        
        ArrayList<String>names;
        names = new ArrayList<String>();

        for(String student : students){
            names.add(student);
        }
        //Manipulations

        //size
        System.out.println(names.size());

        //get
        System.out.println(names.get(2));

        //set
        names.set(0, "Amine");
        System.out.println();

        //remove
        names.remove(3);
        System.out.println(names);

        //indexOf
        System.out.println(names.indexOf(2));
    
    }
}