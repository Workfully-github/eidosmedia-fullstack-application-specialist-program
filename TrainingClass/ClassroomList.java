import java.util.ArrayList;

public class ClassroomList {
    
    public static void main (String[] args) {
    
        ArrayList<String> names = new ArrayList<String>();

        names.add("Ricardo");
        names.add(0, "Sidi");
        names.add(0, "Abderraouf");
        names.add(0, "Hugo");

        names.set(0, "Amine");

        names.remove(3);

        System.out.println(names);
        System.out.println(names.size());
        System.out.println(names.get(2));
        System.out.println(names.indexOf("Amine"));

    }
}
