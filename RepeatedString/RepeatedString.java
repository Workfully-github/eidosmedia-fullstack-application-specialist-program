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
         * n divided by string.length() will tell us how many times string can fit in n
         * 10 / 3 = 3.33.. which means the string "aba" fits 3 times and a bit more
         * We use Mathematical "Rule of Three" to solve this problem
         * a / b = c / d
         */

        System.out.println("Word: " + string);
        return Math.round((n / string.length()) * counter ); 
    }

    public static void main(String[] args) {

        System.out.println(repeatedStringMethod("aba", 10d) + "\n");

        System.out.println(repeatedStringMethod("a", 1000000000000d) + "\n"); 

        System.out.println(repeatedStringMethod("ricardo", 10d) + "\n" );

        System.out.println(repeatedStringMethod("aab", 882787d)  + "\n");

        System.out.println(repeatedStringMethod("ceebbcb", 817723d) + "\n");

        System.out.println(repeatedStringMethod("jdiacikk", 899491d) + "\n");


    }
    
}
