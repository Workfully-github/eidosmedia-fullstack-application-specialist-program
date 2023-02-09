package repeatedString;

public class RepeatedString {

    public static int count_a(String s, int n){
        int count = 0;
        int nb_a_in_s = 0;
        for(int i=0; i< s.length(); i++){
            if (s.charAt(i) == 'a'){
                nb_a_in_s++;
            }
        }

        int infinite_str_len = s.length();
        while(infinite_str_len <= n){
            count += nb_a_in_s;
            infinite_str_len += s.length();
        }

        if (infinite_str_len > n){
            infinite_str_len -= s.length();
            int diff = n - infinite_str_len;
            for(int l=0; l<diff; l++){
                if (s.charAt(l) == 'a'){
                    count++;
                }
            }
            infinite_str_len += diff;

        }
        return count;
    }

    public static void main(String[] args) {
        String s = "a";
        int n = 1000000000;
        
        System.out.println(" the number of a is : " + RepeatedString.count_a(s, n));


    }
}
