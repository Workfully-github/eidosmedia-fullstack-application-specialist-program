public class RepeatedString {
    public static void main (String[] args) {
        int numberA = 0;
        int n = 100;
        String letters = "ricardo";
        int numbLetters = letters.length();
        int restOfLetters = n - numbLetters;
        int letterNotCounted = restOfLetters % numbLetters;

        // First let's count the number of times that a's appear in the string
        for (int i = 0; i < letters.length(); i++) {
            if (letters.charAt(i) == 'a') {
                numberA ++;
            }
        }

        // Now we can count the number of times that the whole string is repeated.
        // So we sum to the number of a's the number of times that the word is repeated times the number
        // of a's in the initial string.
        numberA = (restOfLetters / numbLetters) * numberA + numberA;

        // To finish we just need to take into account the letters that are not enough to
        // complete the whole string.
        // So we know that the number of missing letters is smaller than the length of the initial string.
        // This means that we only need to count the number of a's in a string smaller than our inicial
        // string and add it to the number of a's.
        for (int j = 0; j < letterNotCounted; j++) {
            if (letters.charAt(j) == 'a') {
                numberA ++;
            }
        }
        System.out.println(numberA);
    }
}