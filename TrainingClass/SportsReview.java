import java.util.ArrayList;

public class SportsReview {
    
    public Sport soccer, basketball, tennis, golf;

    public static void main(String[] args) {

        Soccer soccer = new Soccer();
        Basketball basketball = new Basketball();
        Tennis tennis = new Tennis();
        Golf golf = new Golf();

        ArrayList<Sport> allSports = new ArrayList<Sport>();

        allSports.add(soccer);
        allSports.add(basketball);
        allSports.add(tennis);
        allSports.add(golf);

        for (Sport sport : allSports) {
            sport.printInfo();
        }
    }
}
