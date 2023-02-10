package RepeatedString;

public class RepeatedStringsArchivedIdea {

    private static String concatenatorForInts(String string, int n){

        String concatenatedString = "";

        //Without the power of Streams will take forever to calculate
        /* while(concatenatedString.length() < n){
            concatenatedString += string;
            System.out.println(concatenatedString.length());
        }

        return concatenatedString; */

        //With the power of Streams it's much faster to calculate but only works with int
        return concatenatedString
            .concat(string)
            .repeat(n)
            .substring(0, n);
    }
}