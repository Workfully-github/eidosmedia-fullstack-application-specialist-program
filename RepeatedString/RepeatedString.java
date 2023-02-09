package RepeatedString;

public class RepeatedString {

    public static long repeatedStringMethod(String string, double n){
        

        // Let's count how many 'a' the string has
        double counter = 0;

        for (char letter : string.toCharArray()) {
            if(letter == 'a')
                counter++;
        }
        
        /* 
         * 'n' divided by the string length will tell us how many times the word can fit in 'n'
         * The Math.round will always be exact because if result < .49 it means the word would not fit and if result > .50 then it will fit
         * When we multiply by 'counter' we know exactly how many 'a' we have 
         */

        return Math.round((n / string.length()) * counter ); 
    }

    public static void main(String[] args) {

        System.out.println(repeatedStringMethod("aba", 10d));

        System.out.println(repeatedStringMethod("a", 1000000000000d)); 

    }
    
}
