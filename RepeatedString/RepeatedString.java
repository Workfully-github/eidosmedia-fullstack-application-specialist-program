package RepeatedString;

public class RepeatedString {

    public static int repeatedStringMethod(String string, int n){

        int counter = 0;

        String repeatedString = concatenator(string, n);   
        
        for(int i = 0; i < repeatedString.length(); i++){

            if(repeatedString.charAt(i) == 'a')
                counter++;
        }

        return counter;
    }

    private static String concatenator(String string, int n){

        String concatenatedString = "";

        //Without the power of Streams will take forever to calculate
        /*while(concatenatedString.length() < n)
            concatenatedString += string;

        return concatenatedString.substring(0, n);*/

        //With the power of Streams it's much faster to calculate
        return concatenatedString
            .concat(string)
            .repeat(n)
            .substring(0, n);
    }

    public static void main(String[] args) {

        System.out.println(repeatedStringMethod("aba", 10));

        System.out.println(repeatedStringMethod("a", 1000000000));

    }
    
}
