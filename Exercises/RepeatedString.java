public class RepeatedString {
    public static void main (String[] args) {

        int numberA = 0;
        int n = 10;
        String letters = "aba";


        for (int i = 0; i < letters.length(); i++) {
            if (letters.charAt(i) == 'a') {
                numberA ++;
            }
        }

        System.out.println(numberA);
    }
}