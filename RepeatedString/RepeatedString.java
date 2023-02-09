package RepeatedString;

public class RepeatedString {

    public static long repeatedStringMethod(String string, double n){
        
        double counter = 0;

        for (char letter : string.toCharArray()) {
            if(letter == 'a')
                counter++;
        }
        
        return Math.round((n / string.length()) * counter ); 
    }

    public static void main(String[] args) {

        System.out.println(repeatedStringMethod("aba", 10d));

        System.out.println(repeatedStringMethod("a", 1000000000000d)); 

    }
    
}
