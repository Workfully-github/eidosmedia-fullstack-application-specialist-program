public class RepeatedString {
    public static void main(String[] args) {

        String s = "aba";
        double n = 10;

        double letterCounter = 0;
        char[] arrOfS = s.toCharArray();
        for(char letter : arrOfS){
            if(letter == 'a'){
                letterCounter++;
            }
        }

        //how many (a)s in s
        double totalLetterCount = Math.round((n / s.length()) * letterCounter);
       

        System.out.print(totalLetterCount);
    }
}
