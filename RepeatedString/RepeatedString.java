package RepeatedString;

public class RepeatedString {

    public static long count_a(String s, long n){
        long count = 0;
        int nb_a_in_s = 0;
        for(int i=0; i< s.length(); i++){
            if (s.charAt(i) == 'a'){
                nb_a_in_s++;
            }
        }

        long infinite_str_len = s.length();
        while(infinite_str_len <= n){
            count += nb_a_in_s;
            infinite_str_len += s.length();
        }

        if (infinite_str_len > n){
            infinite_str_len -= s.length();
            long diff = n - infinite_str_len;
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
        long n = 10000000000L;
        
        System.out.println(" the number of a is : " + RepeatedString.count_a(s, n));

        String s0 = "aba";
        long n0 = 10;
        
        System.out.println(" the number of a is : " + RepeatedString.count_a(s0, n0));


    }
}
