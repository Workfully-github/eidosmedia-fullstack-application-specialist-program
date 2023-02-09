package CountingValley;
public class CountingValley {

    static int countingValleys(int n, String s) {
        int level = 0;
        int valleys_nb = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'U') {
                level++;
                if (level == 0) {
                    valleys_nb++;
                }
            } else {
                level--;
            }
        }
        return valleys_nb;
    }

    public static void main(String[] args) {
        int nb = 8;
        String steps = "UDDDUDUU";
        int valleysNb = CountingValley.countingValleys(nb, steps);
        
        System.out.println("the number of valley is : " + valleysNb);

    }
    
}
